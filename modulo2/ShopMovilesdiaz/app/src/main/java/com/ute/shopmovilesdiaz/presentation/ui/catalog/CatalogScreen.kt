package com.ute.shopmovilesdiaz.presentation.ui.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ute.shopmovilesdiaz.model.Celular
import com.ute.shopmovilesdiaz.presentation.viewmodel.CartViewModel
import com.ute.shopmovilesdiaz.presentation.viewmodel.CatalogViewModel
import com.ute.shopmovilesdiaz.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    onDetailClick: (Int) -> Unit,
    cartViewModel: CartViewModel,
    viewModel: CatalogViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
    ) {
        Surface(color = Surface, tonalElevation = 0.dp) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Catálogo", style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold, color = TextPrimary)
                    BadgedBox(badge = {
                        val count = cartViewModel.uiState.collectAsStateWithLifecycle().value.itemCount
                        if (count > 0) {
                            Badge(containerColor = Accent) {
                                Text("$count", color = AccentOnDark,
                                    style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }) {
                        Icon(Icons.Default.ShoppingCart, "Carrito", tint = TextSecondary)
                    }
                }

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = state.busqueda,
                    onValueChange = viewModel::actualizarBusqueda,
                    placeholder = { Text("Buscar teléfonos...", color = TextFaint) },
                    leadingIcon = { Icon(Icons.Default.Search, null, tint = TextSecondary) },
                    trailingIcon = {
                        if (state.busqueda.isNotEmpty()) {
                            IconButton(onClick = { viewModel.actualizarBusqueda("") }) {
                                Icon(Icons.Default.Clear, "Limpiar", tint = TextSecondary)
                            }
                        }
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Accent,
                        unfocusedBorderColor = Border,
                        cursorColor = Accent,
                    ),
                )

                Spacer(Modifier.height(12.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(state.marcas) { marca ->
                        FilterChip(
                            selected = state.filtroMarca == marca,
                            onClick = { viewModel.actualizarFiltroMarca(marca) },
                            label = { Text(marca, style = MaterialTheme.typography.labelSmall) },
                            leadingIcon = if (state.filtroMarca == marca) {{
                                Icon(Icons.Default.Check, null, Modifier.size(FilterChipDefaults.IconSize))
                            }} else null,
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Accent,
                                selectedLabelColor = AccentOnDark,
                                containerColor = Surface2,
                                labelColor = TextSecondary,
                            ),
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(4.dp))

        Text(
            "${state.celulares.size} resultado(s)",
            style = MaterialTheme.typography.labelSmall,
            color = TextFaint,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        )

        if (state.celulares.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.SearchOff, null, Modifier.size(56.dp), tint = TextFaint)
                    Spacer(Modifier.height(12.dp))
                    Text("Sin resultados", color = TextPrimary, fontWeight = FontWeight.Bold)
                    Text("Prueba con otro filtro", color = TextSecondary,
                        style = MaterialTheme.typography.bodySmall)
                }
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(state.celulares, key = { it.id }) { celular ->
                    TarjetaCelularCatalogo(
                        celular = celular,
                        onClick = { onDetailClick(celular.id) },
                    )
                }
                item { Spacer(Modifier.height(80.dp)) }
            }
        }
    }
}

@Composable
private fun TarjetaCelularCatalogo(
    celular: Celular,
    onClick: () -> Unit,
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(containerColor = Surface),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(colorMarca(celular.marca)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    celular.marca.first().uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(celular.modelo, style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold, color = TextPrimary)
                Text(celular.marca, style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary)
                Text(celular.descripcion, style = MaterialTheme.typography.bodySmall,
                    color = TextFaint, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    if (celular.stock > 0) {
                        AssistChip(
                            onClick = {},
                            label = { Text("Stock: ${celular.stock}",
                                style = MaterialTheme.typography.labelSmall) },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Surface2, labelColor = Success,
                            ),
                        )
                    } else {
                        AssistChip(
                            onClick = {},
                            label = { Text("Agotado",
                                style = MaterialTheme.typography.labelSmall) },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Surface2, labelColor = Error,
                            ),
                        )
                    }
                    if (celular.destacado) {
                        AssistChip(
                            onClick = {},
                            label = { Text("Destacado",
                                style = MaterialTheme.typography.labelSmall) },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Color(0xFF1C2E3A),
                                labelColor = Accent,
                            ),
                        )
                    }
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "$${String.format("%.2f", celular.precio)}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Accent, fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(4.dp))
                Icon(
                    Icons.Default.ChevronRight, null,
                    tint = TextFaint, modifier = Modifier.size(20.dp),
                )
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
