// ui/S02_Text.kt
package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun S02_TextScreen() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Sección 2 · Text con estilos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        EtiquetaSeccion("1. Texto básico")
        Text("Teléfono Samsung Galaxy S25 disponible")

        EtiquetaSeccion("2. fontSize + fontWeight + fontStyle")
        Text("iPhone 16 Pro",     fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Samsung Galaxy S25", fontSize = 18.sp, fontStyle  = FontStyle.Italic)
        Text("Xiaomi 14 Pro",     fontSize = 20.sp, fontWeight = FontWeight.Light)

        EtiquetaSeccion("3. Color y decoración")
        Text("Precio: $899",
            color = Color(0xFF1976D2))
        Text("En stock",
            textDecoration = TextDecoration.Underline)
        Text("Agotado",
            textDecoration = TextDecoration.LineThrough,
            color          = MaterialTheme.colorScheme.onSurfaceVariant)

        EtiquetaSeccion("4. maxLines + TextOverflow")
        Text(
            text     = "El Samsung Galaxy S25 Ultra tiene una pantalla Dynamic AMOLED de 6.9 pulgadas con resolución QHD+ y tasa de refresco de 120Hz",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text     = "El iPhone 16 Pro Max incluye el chip A18 Pro con CPU de 6 núcleos y GPU de 6 núcleos, además de 8GB de RAM y almacenamiento de hasta 1TB",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        EtiquetaSeccion("5. Escala tipográfica Material 3")
        Text("headlineMedium", style = MaterialTheme.typography.headlineMedium)
        Text("titleLarge",     style = MaterialTheme.typography.titleLarge)
        Text("bodyLarge",      style = MaterialTheme.typography.bodyLarge)
        Text("bodySmall",      style = MaterialTheme.typography.bodySmall)
        Text("labelSmall",     style = MaterialTheme.typography.labelSmall)

        EtiquetaSeccion("6. TextAlign")
        Text(
            text      = "Oferta: 12 meses sin intereses",
            textAlign = TextAlign.Center,
            modifier  = Modifier.fillMaxWidth()
        )
        Text(
            text      = "Envío gratis a todo el país",
            textAlign = TextAlign.End,
            modifier  = Modifier.fillMaxWidth()
        )
    }
}

// Composable de etiqueta reutilizable — se declara internal para que
// otros archivos del mismo módulo puedan usarla
@Composable
internal fun EtiquetaSeccion(texto: String) {
    Text(
        text  = texto,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview(showBackground = true)
@Composable
fun S02_Preview() {
    MaterialTheme { S02_TextScreen() }
}