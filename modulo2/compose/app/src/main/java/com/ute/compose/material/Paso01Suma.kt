// ui/Paso01Suma.kt
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
fun Paso01_SumaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso 1 · Suma de presupuestos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        DemoSuma()
    }
}

// ── Demo 2: Suma de números ──────────────────────────────────────────────────
@Composable
private fun DemoSuma() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    // Validación: comprobar que ambos campos sean números válidos
    val n1Valido = numero1.toDoubleOrNull() != null
    val n2Valido = numero2.toDoubleOrNull() != null
    val formularioValido = n1Valido && n2Valido

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Suma de dos números",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value           = numero1,
            onValueChange   = { numero1 = it },
            label           = { Text("Primer número") },
            placeholder     = { Text("Ej: 10") },
            leadingIcon     = { Icon(Icons.Default.Add, null) },
            isError         = numero1.isNotEmpty() && !n1Valido,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction    = ImeAction.Next
            ),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = numero2,
            onValueChange   = { numero2 = it },
            label           = { Text("Segundo número") },
            placeholder     = { Text("Ej: 20") },
            leadingIcon     = { Icon(Icons.Default.Add, null) },
            isError         = numero2.isNotEmpty() && !n2Valido,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction    = ImeAction.Done
            ),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val val1 = numero1.toDoubleOrNull() ?: 0.0
                val val2 = numero2.toDoubleOrNull() ?: 0.0
                resultado = (val1 + val2).toString()
            },
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Calculate, null)
            Spacer(Modifier.width(8.dp))
            Text("Calcular Suma")
        }

        if (resultado.isNotEmpty()) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
                    Text(
                        "Resultado: $resultado",
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
fun Paso01_Preview() {
    MaterialTheme { Paso01_SumaScreen() }
}
