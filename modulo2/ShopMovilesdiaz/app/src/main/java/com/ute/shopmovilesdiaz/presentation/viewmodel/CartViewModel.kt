package com.ute.shopmovilesdiaz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ute.shopmovilesdiaz.data.repository.CelularRepository
import com.ute.shopmovilesdiaz.model.Celular
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CartItem(
    val celular: Celular,
    val cantidad: Int = 1,
)

data class CartUiState(
    val items: List<CartItem> = emptyList(),
    val total: Double = 0.0,
    val itemCount: Int = 0,
)

class CartViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState())
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    fun agregarAlCarrito(celularId: Int) {
        val celular = CelularRepository.obtenerPorId(celularId) ?: return
        val current = _uiState.value
        val existente = current.items.find { it.celular.id == celularId }

        val newItems = if (existente != null) {
            current.items.map {
                if (it.celular.id == celularId) it.copy(cantidad = it.cantidad + 1) else it
            }
        } else {
            current.items + CartItem(celular)
        }
        actualizarEstado(newItems)
    }

    fun eliminarDelCarrito(celularId: Int) {
        val current = _uiState.value
        val newItems = current.items.filter { it.celular.id != celularId }
        actualizarEstado(newItems)
    }

    fun actualizarCantidad(celularId: Int, nuevaCantidad: Int) {
        if (nuevaCantidad <= 0) {
            eliminarDelCarrito(celularId)
            return
        }
        val current = _uiState.value
        val newItems = current.items.map {
            if (it.celular.id == celularId) it.copy(cantidad = nuevaCantidad) else it
        }
        actualizarEstado(newItems)
    }

    fun limpiarCarrito() {
        _uiState.value = CartUiState()
    }

    private fun actualizarEstado(items: List<CartItem>) {
        val total = items.sumOf { it.celular.precio * it.cantidad }
        val itemCount = items.sumOf { it.cantidad }
        _uiState.value = CartUiState(items = items, total = total, itemCount = itemCount)
    }
}
