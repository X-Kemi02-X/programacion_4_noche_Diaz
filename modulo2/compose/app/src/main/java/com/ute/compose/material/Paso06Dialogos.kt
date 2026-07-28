package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ute.compose.model.Contacto
import com.ute.compose.model.contactosDeMuestra
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso06_DialogosScreen() {
    var productos        by remember { mutableStateOf(contactosDeMuestra) }
    var busqueda         by remember { mutableStateOf("") }
    var filtro           by remember { mutableStateOf("Todos") }
    var destinoActual    by remember { mutableStateOf("catalogo") }

    var mostrarNuevo     by remember { mutableStateOf(false) }
    var productoAEliminar by remember { mutableStateOf<Contacto?>(null) }

    var mensajeSnack     by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(mensajeSnack) {
        mensajeSnack?.let {
            snackbarHostState.showSnackbar(it)
            mensajeSnack = null
        }
    }

    val productosFiltrados = productos
        .filter { c -> if (filtro == "Destacados") c.favorito else true }
        .filter { c -> busqueda.isBlank() || c.nombre.contains(busqueda, ignoreCase = true) }

    val destinos = listOf(
        DestinoNav("catalogo",  "Catálogo", Icons.Filled.PhoneAndroid,     Icons.Outlined.PhoneAndroid),
        DestinoNav("destacados", "Destacados", Icons.Filled.Favorite,     Icons.Outlined.FavoriteBorder),
        DestinoNav("perfil",    "Perfil",    Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Tienda (${productos.size})", fontWeight = FontWeight.Bold)
                },
                actions = {
                    IconButton(onClick = {
                        filtro = if (filtro == "Destacados") "Todos" else "Destacados"
                    }) {
                        Icon(
                            imageVector = if (filtro == "Destacados")
                                Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Filtrar destacados",
                            tint = if (filtro == "Destacados")
                                MaterialTheme.colorScheme.error
                            else
                                MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    val sel = destinoActual == destino.ruta
                    NavigationBarItem(
                        selected = sel,
                        onClick  = { destinoActual = destino.ruta },
                        icon     = {
                            Icon(if (sel) destino.iconoActivo else destino.iconoInactivo,
                                destino.etiqueta)
                        },
                        label = { Text(destino.etiqueta) }
                    )
                }
            }
        },
        floatingActionButton = {
            if (destinoActual == "catalogo") {
                FloatingActionButton(onClick = { mostrarNuevo = true }) {
                    Icon(Icons.Default.Add, "Nuevo producto")
                }
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }

    ) { paddingValues ->
        when (destinoActual) {
            "catalogo" -> ContenidoCatalogo(
                productos    = productosFiltrados,
                busqueda     = busqueda,
                filtro       = filtro,
                onBusqueda   = { busqueda = it },
                onFiltro     = { filtro = it },
                onFavorito   = { id ->
                    productos = productos.map { c ->
                        if (c.id == id) c.copy(favorito = !c.favorito) else c
                    }
                },
                onVerDetalle     = { nombre -> mensajeSnack = "Viendo detalles de $nombre..." },
                onEliminar   = { producto -> productoAEliminar = producto },
                modifier     = Modifier.padding(paddingValues)
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

    if (mostrarNuevo) {
        DialogNuevoProducto(
            onDismiss = { mostrarNuevo = false },
            onGuardar = { nuevo ->
                productos    = productos + nuevo
                mostrarNuevo = false
                mensajeSnack = "✅ ${nuevo.nombre} agregado al catálogo"
            }
        )
    }

    productoAEliminar?.let { producto ->
        AlertDialog(
            onDismissRequest = { productoAEliminar = null },
            icon    = {
                Icon(Icons.Default.Warning, null,
                    tint = MaterialTheme.colorScheme.error)
            },
            title   = { Text("Eliminar producto") },
            text    = {
                Text("¿Seguro que quieres eliminar ${producto.nombre}? " +
                        "Esta acción no se puede deshacer.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        productos         = productos.filter { it.id != producto.id }
                        mensajeSnack      = "🗑 ${producto.nombre} eliminado"
                        productoAEliminar = null
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) { Text("Eliminar") }
            },
            dismissButton = {
                OutlinedButton(onClick = { productoAEliminar = null }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
private fun ContenidoCatalogo(
    productos:  List<Contacto>,
    busqueda:   String,
    filtro:     String,
    onBusqueda: (String) -> Unit,
    onFiltro:   (String) -> Unit,
    onFavorito: (Int) -> Unit,
    onVerDetalle:   (String) -> Unit,
    onEliminar: (Contacto) -> Unit,
    modifier:   Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        OutlinedTextField(
            value         = busqueda,
            onValueChange = onBusqueda,
            placeholder   = { Text("Buscar teléfono...") },
            leadingIcon   = { Icon(Icons.Default.Search, null) },
            trailingIcon  = {
                if (busqueda.isNotEmpty())
                    IconButton(onClick = { onBusqueda("") }) {
                        Icon(Icons.Default.Clear, "Limpiar")
                    }
            },
            singleLine = true,
            modifier   = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding        = PaddingValues(horizontal = 16.dp)
        ) {
            items(listOf("Todos", "Destacados")) { opcion ->
                FilterChip(
                    selected    = filtro == opcion,
                    onClick     = { onFiltro(opcion) },
                    label       = { Text(opcion) },
                    leadingIcon = if (filtro == opcion) {{
                        Icon(Icons.Default.Check, null,
                            Modifier.size(FilterChipDefaults.IconSize))
                    }} else null
                )
            }
        }

        Spacer(Modifier.height(4.dp))

        if (productos.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.SearchOff, null, Modifier.size(56.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.height(8.dp))
                    Text("Sin resultados",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        } else {
            LazyColumn(
                contentPadding      = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text("${productos.size} teléfono(s)",
                        style    = MaterialTheme.typography.labelSmall,
                        color    = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 4.dp))
                }
                items(productos, key = { it.id }) { producto ->
                    TarjetaProductoCompleta(
                        contacto   = producto,
                        onFavorito = { onFavorito(producto.id) },
                        onVerDetalle   = { onVerDetalle(producto.nombre) },
                        onEliminar = { onEliminar(producto) }
                    )
                }
                item { Spacer(Modifier.height(100.dp)) }
            }
        }
    }
}

@Composable
private fun TarjetaProductoCompleta(
    contacto:  Contacto,
    onFavorito: () -> Unit,
    onVerDetalle:  () -> Unit,
    onEliminar: () -> Unit
) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier          = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                , contentAlignment = Alignment.Center
            ) {
                Text(
                    contacto.nombre.first().uppercase(),
                    style      = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color      = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(contacto.nombre, fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleSmall)
                Text(contacto.email,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("Precio: ${contacto.telefono}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            IconButton(onClick = onFavorito) {
                Icon(
                    if (contacto.favorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    null,
                    tint = if (contacto.favorito) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = onVerDetalle) {
                Icon(Icons.Default.Visibility, null,
                    tint = MaterialTheme.colorScheme.primary)
            }
            IconButton(onClick = onEliminar) {
                Icon(Icons.Default.Delete, null,
                    tint = MaterialTheme.colorScheme.error)
            }
        }
    }
}

@Composable
private fun DialogNuevoProducto(
    onDismiss: () -> Unit,
    onGuardar: (Contacto) -> Unit
) {
    var nombre   by remember { mutableStateOf("") }
    var email    by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    val nombreValido   = nombre.trim().length >= 2
    val emailValido    = email.contains("@") && email.contains(".")
    val precioValido = precio.length >= 1
    val valido         = nombreValido && emailValido && precioValido

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier            = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Nuevo teléfono",
                    style      = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold)

                OutlinedTextField(
                    value           = nombre,
                    onValueChange   = { nombre = it },
                    label           = { Text("Modelo") },
                    leadingIcon     = { Icon(Icons.Default.PhoneAndroid, null) },
                    isError         = nombre.isNotEmpty() && !nombreValido,
                    singleLine      = true,
                    modifier        = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                )

                OutlinedTextField(
                    value           = email,
                    onValueChange   = { email = it },
                    label           = { Text("Marca") },
                    leadingIcon     = { Icon(Icons.Default.Business, null) },
                    isError         = email.isNotEmpty() && !emailValido,
                    singleLine      = true,
                    modifier        = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction    = ImeAction.Next
                    )
                )

                OutlinedTextField(
                    value           = precio,
                    onValueChange   = { precio = it },
                    label           = { Text("Precio") },
                    leadingIcon     = { Icon(Icons.Default.AttachMoney, null) },
                    isError         = precio.isNotEmpty() && !precioValido,
                    singleLine      = true,
                    modifier        = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction    = ImeAction.Done
                    )
                )

                Row(
                    modifier              = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment     = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onDismiss) { Text("Cancelar") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick  = {
                            onGuardar(
                                Contacto(
                                    id       = System.currentTimeMillis().toInt(),
                                    nombre   = nombre.trim(),
                                    email    = email.trim(),
                                    telefono = precio.trim()
                                )
                            )
                        },
                        enabled  = valido
                    ) { Text("Agregar") }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso06_Preview() {
    MaterialTheme { Paso06_DialogosScreen() }
}
