// ui/S03_Button.kt
package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun S03_ButtonScreen() {
    // Estado para mostrar cuál botón fue presionado
    var ultimoClick by remember { mutableStateOf("(ninguno)") }

    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sección 3 · Variantes de Button",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // Panel de feedback — muestra el último click
        Surface(
            color    = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text     = "Último click: $ultimoClick",
                modifier = Modifier.padding(12.dp),
                style    = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(Modifier.height(4.dp))

        Button(
            onClick  = { ultimoClick = "Comprar Samsung" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Comprar Samsung Galaxy") }

        // Button con ícono dentro del slot de contenido
        Button(
            onClick  = { ultimoClick = "Agregar iPhone al carrito" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector        = Icons.Default.Add,
                contentDescription = null,
                modifier           = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("Agregar al carrito")
        }

        OutlinedButton(
            onClick  = { ultimoClick = "Ver detalles del Pixel" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver detalles") }

        TextButton(
            onClick  = { ultimoClick = "Ver más ofertas" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver más ofertas") }

        ElevatedButton(
            onClick  = { ultimoClick = "Comparar modelos" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Comparar modelos") }

        FilledTonalButton(
            onClick  = { ultimoClick = "Favoritos" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Agregar a favoritos") }

        Button(
            onClick  = { },
            enabled  = false,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Agotado (sin stock)") }

        HorizontalDivider()

        // IconButton — solo ícono, sin texto
        EtiquetaSeccion("IconButton")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { ultimoClick = "Favorito" }) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorito",
                    tint = MaterialTheme.colorScheme.error)
            }
            IconButton(onClick = { ultimoClick = "Carrito" }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito",
                    tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S03_Preview() {
    MaterialTheme { S03_ButtonScreen() }
}