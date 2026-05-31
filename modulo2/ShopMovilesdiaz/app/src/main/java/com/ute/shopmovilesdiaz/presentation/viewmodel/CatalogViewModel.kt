package com.ute.shopmovilesdiaz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ute.shopmovilesdiaz.data.repository.CelularRepository
import com.ute.shopmovilesdiaz.model.Celular
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CatalogUiState(
    val celulares: List<Celular> = emptyList(),
    val busqueda: String = "",
    val filtroMarca: String = "Todas",
    val marcas: List<String> = emptyList(),
)

class CatalogViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CatalogUiState())
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    private val todosLosCelulares = CelularRepository.obtenerTodos()

    init {
        _uiState.value = CatalogUiState(
            celulares = todosLosCelulares,
            marcas = listOf("Todas") + CelularRepository.obtenerMarcas(),
        )
    }

    fun actualizarBusqueda(query: String) {
        _uiState.value = _uiState.value.copy(busqueda = query)
        aplicarFiltros()
    }

    fun actualizarFiltroMarca(marca: String) {
        _uiState.value = _uiState.value.copy(filtroMarca = marca)
        aplicarFiltros()
    }

    private fun aplicarFiltros() {
        val state = _uiState.value
        val filtrados = todosLosCelulares
            .filter { c ->
                if (state.filtroMarca == "Todas") true else c.marca == state.filtroMarca
            }
            .filter { c ->
                state.busqueda.isBlank() ||
                        c.modelo.contains(state.busqueda, ignoreCase = true) ||
                        c.marca.contains(state.busqueda, ignoreCase = true)
            }
        _uiState.value = state.copy(celulares = filtrados)
    }
}
