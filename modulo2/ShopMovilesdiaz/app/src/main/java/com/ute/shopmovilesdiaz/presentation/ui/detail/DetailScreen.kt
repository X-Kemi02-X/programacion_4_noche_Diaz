package com.ute.shopmovilesdiaz.presentation.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ute.shopmovilesdiaz.data.repository.CelularRepository
import com.ute.shopmovilesdiaz.model.Celular
import com.ute.shopmovilesdiaz.presentation.components.ShopButton
import com.ute.shopmovilesdiaz.presentation.viewmodel.CartViewModel
import com.ute.shopmovilesdiaz.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    celularId: Int,
    onBack: () -> Unit,
    cartViewModel: CartViewModel,
    snackbarHostState: SnackbarHostState,
) {
    val celular = remember(celularId) { CelularRepository.obtenerPorId(celularId) }

    if (celular == null) {
        Box(Modifier.fillMaxSize().background(Background), contentAlignment = Alignment.Center) {
            Text("Teléfono no encontrado", color = Error)
        }
        return
    }

    Box(modifier = Modifier.fillMaxSize().background(Background)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Surface(color = Surface, tonalElevation = 0.dp) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, "Volver", tint = TextPrimary)
                    }
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Share, "Compartir", tint = TextSecondary)
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            Column(
                modifier = Modifier.padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(colorMarca(celular.marca)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        celular.marca.first().uppercase(),
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }

                Spacer(Modifier.height(20.dp))

                Text(celular.modelo, style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold, color = TextPrimary)
                Text(celular.marca, style = MaterialTheme.typography.titleMedium,
                    color = TextSecondary)

                Spacer(Modifier.height(8.dp))

                Text(
                    "$${String.format("%.2f", celular.precio)}",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    color = Accent,
                )
            }

            Spacer(Modifier.height(24.dp))

            Surface(color = Surface, shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Descripción", style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold, color = TextPrimary)
                    Spacer(Modifier.height(8.dp))
                    Text(celular.descripcion, style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary)
                }
            }

            Spacer(Modifier.height(12.dp))

            Surface(color = Surface, shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Especificaciones", style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold, color = TextPrimary)
                    Spacer(Modifier.height(8.dp))
                    Text(celular.especificaciones, style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary)
                }
            }

            Spacer(Modifier.height(12.dp))

            Surface(color = Surface, shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Disponibilidad", style = MaterialTheme.typography.titleSmall,
                        color = TextPrimary)
                    if (celular.stock > 0) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.CheckCircle, null,
                                tint = Success, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("En stock (${celular.stock} uds)", color = Success,
                                style = MaterialTheme.typography.bodySmall)
                        }
                    } else {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Cancel, null,
                                tint = Error, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("Agotado", color = Error,
                                style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }

            Spacer(Modifier.height(28.dp))

            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                ShopButton(
                    text = "Agregar al carrito",
                    onClick = {
                        cartViewModel.agregarAlCarrito(celular.id)
                    },
                    enabled = celular.stock > 0,
                )
            }

            Spacer(Modifier.height(32.dp))
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
