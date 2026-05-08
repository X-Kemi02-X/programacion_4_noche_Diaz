// ui/Paso02CompraProducto.kt
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
fun Paso01CompraProducto() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            "Compra de Producto",
            style = MaterialTheme.typography.titleMedium
        )
        HorizontalDivider()
        DemoCompraProducto()
    }
}

@Composable
private fun DemoCompraProducto() {

    var producto by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var subtotal by remember { mutableStateOf(0.0) }
    var descuento by remember { mutableStateOf(0.0) }
    var total by remember { mutableStateOf(0.0) }
    val cantidadValida = cantidad.toIntOrNull() != null
    val precioValido = precio.toDoubleOrNull() != null
    val formularioValido =
        producto.isNotEmpty() &&
                cantidadValida &&
                precioValido

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedTextField(
            value = producto,
            onValueChange = { producto = it },
            label = { Text("Nombre del producto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad comprada") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio unitario") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val cant = cantidad.toIntOrNull() ?: 0
                val prec = precio.toDoubleOrNull() ?: 0.0
                subtotal = cant * prec
                descuento = when {
                    subtotal > 50 -> subtotal * 0.10
                    subtotal in 20.0..50.0 -> subtotal * 0.05
                    else -> 0.0
                }
                total = subtotal - descuento
            },
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Calculate, null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Calcular")
        }

        if (total > 0) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Producto: $producto")
                    Text("Subtotal: $subtotal")
                    Text("Descuento aplicado: $descuento")
                    Text(
                        "Total a pagar: $total",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso02Preview() {

    MaterialTheme {
        Paso01CompraProducto()
    }
}