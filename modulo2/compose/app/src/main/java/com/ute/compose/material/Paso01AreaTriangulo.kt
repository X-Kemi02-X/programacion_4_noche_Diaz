// ui/Paso01AreaTriangulo.kt
package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01AreaTriangulo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(
            "Paso 1 · Área de pantalla (pulgadas)",
            style = MaterialTheme.typography.titleMedium
        )

        HorizontalDivider()

        DemoAreaTriangulo()
    }
}

// ── Demo: Área de un triángulo ─────────────────────────────
@Composable
private fun DemoAreaTriangulo() {

    var base by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    // Validación
    val baseValida = base.toDoubleOrNull() != null
    val alturaValida = altura.toDoubleOrNull() != null
    val formularioValido = baseValida && alturaValida

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            "Calcular área de pantalla",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = base,
            onValueChange = { base = it },
            label = { Text("Base") },
            placeholder = { Text("Ej: 10") },
            leadingIcon = {
                Icon(Icons.Default.Straighten, null)
            },
            isError = base.isNotEmpty() && !baseValida,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura") },
            placeholder = { Text("Ej: 5") },
            leadingIcon = {
                Icon(Icons.Default.Height, null)
            },
            isError = altura.isNotEmpty() && !alturaValida,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {

                val b = base.toDoubleOrNull() ?: 0.0
                val h = altura.toDoubleOrNull() ?: 0.0

                val area = (b * h) / 2

                resultado = area.toString()
            },
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(Icons.Default.Calculate, null)

            Spacer(Modifier.width(8.dp))

            Text("Calcular Área")
        }

        if (resultado.isNotEmpty()) {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth()
            ) {

                Box(
                    Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        "Área pantalla: $resultado pulg²",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01Preview() {

    MaterialTheme {
        Paso01AreaTriangulo()
    }
}