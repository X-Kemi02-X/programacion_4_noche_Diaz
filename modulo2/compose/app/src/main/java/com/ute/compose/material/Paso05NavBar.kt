// ui/Paso05_NavBar.kt
package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.compose.model.Contacto
import com.ute.compose.model.contactosDeMuestra

data class DestinoNav(
    val ruta:          String,
    val etiqueta:      String,
    val iconoActivo:   ImageVector,
    val iconoInactivo: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso05_NavBarScreen() {
    var destinoActual by remember { mutableStateOf("catalogo") }
    var productos     by remember { mutableStateOf(contactosDeMuestra) }

    val destinos = listOf(
        DestinoNav("catalogo",  "Catálogo", Icons.Filled.PhoneAndroid,       Icons.Outlined.PhoneAndroid),
        DestinoNav("destacados", "Destacados", Icons.Filled.Favorite,     Icons.Outlined.FavoriteBorder),
        DestinoNav("perfil",    "Perfil",    Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tienda Móvil", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    val seleccionado = destinoActual == destino.ruta
                    NavigationBarItem(
                        selected = seleccionado,
                        onClick  = { destinoActual = destino.ruta },
                        icon     = {
                            Icon(
                                imageVector        = if (seleccionado) destino.iconoActivo
                                else destino.iconoInactivo,
                                contentDescription = destino.etiqueta
                            )
                        },
                        label = { Text(destino.etiqueta) }
                    )
                }
            }
        },

        floatingActionButton = {
            if (destinoActual == "catalogo") {
                FloatingActionButton(onClick = { }) {
                    Icon(Icons.Default.ShoppingCart, "Carrito")
                }
            }
        }

    ) { paddingValues ->
        when (destinoActual) {
            "catalogo" -> PantallaCatalogoContent(
                productos  = productos,
                onFavorito = { id ->
                    productos = productos.map { c ->
                        if (c.id == id) c.copy(favorito = !c.favorito) else c
                    }
                },
                modifier   = Modifier.padding(paddingValues)
            )
            "destacados" -> PantallaDestacadosContent(
                destacados = productos.filter { it.favorito },
                modifier  = Modifier.padding(paddingValues)
            )
            "perfil"    -> PantallaPerfilContent(
                modifier  = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
private fun PantallaCatalogoContent(
    productos:  List<Contacto>,
    onFavorito: (Int) -> Unit,
    modifier:   Modifier = Modifier
) {
    LazyColumn(
        modifier            = modifier,
        contentPadding      = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(productos, key = { it.id }) { producto ->
            TarjetaContacto(
                contacto   = producto,
                onFavorito = { onFavorito(producto.id) },
                onVerDetalle = { }
            )
        }
        item { Spacer(Modifier.height(80.dp)) }
    }
}

@Composable
fun PantallaDestacadosContent(
    destacados: List<Contacto>,
    modifier:  Modifier = Modifier
) {
    if (destacados.isEmpty()) {
        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.FavoriteBorder, null,
                    Modifier.size(56.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(12.dp))
                Text("Sin destacados aún",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("Toca el corazón en un producto",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    } else {
        LazyColumn(
            modifier            = modifier,
            contentPadding      = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(destacados, key = { it.id }) { producto ->
                TarjetaContacto(contacto = producto)
            }
        }
    }
}

@Composable
fun PantallaPerfilContent(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.AccountCircle, null, Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(12.dp))
            Text("Mi Perfil", style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)
            Text("Próximamente...",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso05_Preview() {
    MaterialTheme { Paso05_NavBarScreen() }
}
