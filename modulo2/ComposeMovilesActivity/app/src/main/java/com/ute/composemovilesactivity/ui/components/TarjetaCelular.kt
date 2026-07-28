package com.ute.composemovilesactivity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ute.composemovilesactivity.model.Celular

@Composable
fun TarjetaCelular(
    celular: Celular,
    onFavorito: () -> Unit,
    onComprar: () -> Unit,
) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(colorMarca(celular.marca)),
                contentAlignment = Alignment.Center
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
                Text(celular.modelo,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold)
                Text(celular.marca,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(celular.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)
                Spacer(Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    if (celular.stock > 0) {
                        AssistChip(
                            onClick = {},
                            label = { Text("Stock: ${celular.stock}",
                                style = MaterialTheme.typography.labelSmall) }
                        )
                    } else {
                        AssistChip(
                            onClick = {},
                            label = { Text("Agotado",
                                style = MaterialTheme.typography.labelSmall) },
                            colors = AssistChipDefaults.assistChipColors(
                                labelColor = MaterialTheme.colorScheme.error
                            )
                        )
                    }
                    if (celular.destacado) {
                        AssistChip(
                            onClick = {},
                            label = { Text("Destacado",
                                style = MaterialTheme.typography.labelSmall) },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Color(0xFFFFF3E0),
                                labelColor = Color(0xFFE65100)
                            )
                        )
                    }
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "$${String.format("%.2f", celular.precio)}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(6.dp))
                Button(
                    onClick = onComprar,
                    enabled = celular.stock > 0,
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(Icons.Default.ShoppingCart, null, Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Comprar", style = MaterialTheme.typography.labelSmall)
                }
                IconButton(onClick = onFavorito) {
                    Icon(
                        if (celular.favorito) Icons.Default.Favorite
                        else Icons.Default.FavoriteBorder,
                        "Favorito",
                        tint = if (celular.favorito)
                            MaterialTheme.colorScheme.error
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

private fun colorMarca(marca: String): Color = when (marca) {
    "Samsung"  -> Color(0xFF1428A0)
    "Apple"    -> Color(0xFF1C1C1E)
    "Xiaomi"   -> Color(0xFFFF6900)
    "Motorola" -> Color(0xFF5C068C)
    else       -> Color(0xFF1976D2)
}
