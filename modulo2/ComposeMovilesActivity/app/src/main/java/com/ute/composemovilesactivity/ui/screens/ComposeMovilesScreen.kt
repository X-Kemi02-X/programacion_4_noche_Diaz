package com.ute.composemovilesactivity.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.composemovilesactivity.model.Celular
import com.ute.composemovilesactivity.model.celularesDeMuestra
import com.ute.composemovilesactivity.ui.components.TarjetaCelular
import com.ute.composemovilesactivity.ui.theme.ComposeMovilesActivityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeMovilesScreen() {
    var celulares by remember { mutableStateOf(celularesDeMuestra) }
    var busqueda by remember { mutableStateOf("") }
    var filtroMarca by remember { mutableStateOf("Todas") }
    var destinoActual by remember { mutableStateOf("todas") }
    var carritoCount by remember { mutableStateOf(0) }
    var mensajeSnack by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(mensajeSnack) {
        mensajeSnack?.let {
            snackbarHostState.showSnackbar(it)
            mensajeSnack = null
        }
    }

    val marcas = listOf("Todas") + celulares.map { it.marca }.distinct().sorted()

    val celularesFiltrados = celulares
        .filter { c ->
            when (destinoActual) {
                "destacados" -> c.destacado
                "favoritos"  -> c.favorito
                else         -> true
            }
        }
        .filter { c ->
            if (filtroMarca == "Todas") true else c.marca == filtroMarca
        }
        .filter { c ->
            busqueda.isBlank() ||
                    c.modelo.contains(busqueda, ignoreCase = true) ||
                    c.marca.contains(busqueda, ignoreCase = true)
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Catálogo de Celulares", fontWeight = FontWeight.Bold)
                        Text("${celulares.size} modelos disponibles",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f))
                    }
                },
                actions = {
                    BadgedBox(badge = {
                        if (carritoCount > 0) {
                            Badge { Text("$carritoCount") }
                        }
                    }) {
                        Icon(Icons.Default.ShoppingCart, "Carrito",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer)
                    }
                    Spacer(Modifier.width(12.dp))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = destinoActual == "todas",
                    onClick  = { destinoActual = "todas" },
                    icon = {
                        Icon(
                            if (destinoActual == "todas") Icons.Filled.PhoneAndroid
                            else Icons.Outlined.PhoneAndroid,
                            "Todas")
                    },
                    label = { Text("Todas") }
                )
                NavigationBarItem(
                    selected = destinoActual == "destacados",
                    onClick  = { destinoActual = "destacados" },
                    icon = {
                        Icon(
                            if (destinoActual == "destacados") Icons.Filled.Star
                            else Icons.Outlined.Star,
                            "Destacados")
                    },
                    label = { Text("Destacados") }
                )
                NavigationBarItem(
                    selected = destinoActual == "favoritos",
                    onClick  = { destinoActual = "favoritos" },
                    icon = {
                        Icon(
                            if (destinoActual == "favoritos") Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                            "Favoritos")
                    },
                    label = { Text("Favoritos") }
                )
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = busqueda,
                onValueChange = { busqueda = it },
                placeholder = { Text("Buscar por marca o modelo...") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                trailingIcon = {
                    if (busqueda.isNotEmpty()) {
                        IconButton(onClick = { busqueda = "" }) {
                            Icon(Icons.Default.Clear, "Limpiar")
                        }
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(marcas) { marca ->
                    FilterChip(
                        selected = filtroMarca == marca,
                        onClick = { filtroMarca = marca },
                        label = { Text(marca) },
                        leadingIcon = if (filtroMarca == marca) {{
                            Icon(Icons.Default.Check, null,
                                Modifier.size(FilterChipDefaults.IconSize))
                        }} else null
                    )
                }
            }

            Spacer(Modifier.height(4.dp))

            Text(
                "${celularesFiltrados.size} resultado(s)",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            if (celularesFiltrados.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.SearchOff, null, Modifier.size(56.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(Modifier.height(12.dp))
                        Text("No se encontraron celulares",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("Intenta con otro filtro o búsqueda",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(celularesFiltrados, key = { it.id }) { celular ->
                        TarjetaCelular(
                            celular = celular,
                            onFavorito = {
                                celulares = celulares.map { c ->
                                    if (c.id == celular.id) c.copy(favorito = !c.favorito) else c
                                }
                            },
                            onComprar = {
                                if (celular.stock > 0) {
                                    carritoCount++
                                    celulares = celulares.map { c ->
                                        if (c.id == celular.id) c.copy(stock = c.stock - 1) else c
                                    }
                                    mensajeSnack = "${celular.modelo} agregado al carrito"
                                }
                            }
                        )
                    }
                    item { Spacer(Modifier.height(16.dp)) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeMovilesPreview() {
    ComposeMovilesActivityTheme {
        ComposeMovilesScreen()
    }
}
