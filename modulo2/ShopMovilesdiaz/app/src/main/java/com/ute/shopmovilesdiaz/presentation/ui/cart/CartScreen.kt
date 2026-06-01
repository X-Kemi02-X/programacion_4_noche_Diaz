package com.ute.shopmovilesdiaz.presentation.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ute.shopmovilesdiaz.presentation.components.ShopButton
import com.ute.shopmovilesdiaz.presentation.viewmodel.CartItem
import com.ute.shopmovilesdiaz.presentation.viewmodel.CartViewModel
import com.ute.shopmovilesdiaz.theme.*

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
    snackbarHostState: SnackbarHostState,
) {
    val state by cartViewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
    ) {
        Surface(color = Surface, tonalElevation = 0.dp) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Carrito", style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold, color = TextPrimary)
                if (state.items.isNotEmpty()) {
                    TextButton(onClick = { cartViewModel.limpiarCarrito() }) {
                        Icon(Icons.Default.Delete, null, Modifier.size(18.dp),
                            tint = Error)
                        Spacer(Modifier.width(4.dp))
                        Text("Vaciar", color = Error)
                    }
                }
            }
        }

        if (state.items.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.ShoppingCart, null, Modifier.size(64.dp),
                        tint = TextFaint)
                    Spacer(Modifier.height(16.dp))
                    Text("Tu carrito está vacío", style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary)
                    Text("Explora el catálogo y agrega productos",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary, textAlign = TextAlign.Center)
                }
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f),
            ) {
                items(state.items, key = { it.celular.id }) { item ->
                    TarjetaItemCarrito(
                        item = item,
                        onEliminar = { cartViewModel.eliminarDelCarrito(item.celular.id) },
                        onIncrementar = { cartViewModel.actualizarCantidad(item.celular.id, item.cantidad + 1) },
                        onDecrementar = { cartViewModel.actualizarCantidad(item.celular.id, item.cantidad - 1) },
                    )
                }
            }

            Surface(color = Surface, tonalElevation = 0.dp) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text("Total", style = MaterialTheme.typography.titleMedium,
                            color = TextPrimary, fontWeight = FontWeight.SemiBold)
                        Text(
                            "$${String.format("%.2f", state.total)}",
                            style = MaterialTheme.typography.titleLarge,
                            color = Accent, fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    ShopButton(
                        text = "Confirmar compra",
                        onClick = {
                            cartViewModel.limpiarCarrito()
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun TarjetaItemCarrito(
    item: CartItem,
    onEliminar: () -> Unit,
    onIncrementar: () -> Unit,
    onDecrementar: () -> Unit,
) {
    Surface(
        color = Surface,
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(colorMarca(item.celular.marca)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    item.celular.marca.first().uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(item.celular.modelo, style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold, color = TextPrimary)
                Text(
                    "$${String.format("%.2f", item.celular.precio)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Accent,
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    FilledTonalButton(
                        onClick = onDecrementar,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(32.dp),
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = Surface2,
                            contentColor = TextPrimary,
                        ),
                    ) { Text("−", style = MaterialTheme.typography.titleSmall) }

                    Text(
                        "${item.cantidad}",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextPrimary,
                    )

                    FilledTonalButton(
                        onClick = onIncrementar,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(32.dp),
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = Surface2,
                            contentColor = TextPrimary,
                        ),
                    ) { Text("+", style = MaterialTheme.typography.titleSmall) }
                }
            }

            Spacer(Modifier.width(8.dp))

            IconButton(onClick = onEliminar) {
                Icon(Icons.Default.Close, "Eliminar", tint = Error, modifier = Modifier.size(18.dp))
            }
        }
    }
}

private fun colorMarca(marca: String): Color = when (marca) {
    "Samsung"  -> Color(0xFF1428A0)
    "Apple"    -> Color(0xFF1C1C1E)
    "Xiaomi"   -> Color(0xFFFF6900)
    "Motorola" -> Color(0xFF5C068C)
    else       -> Color(0xFF58A6FF)
}
