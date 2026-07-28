// model/Producto.kt
package com.ute.compose.model

// Producto local — usado en los pasos 1 al 4
data class Producto(
    val id:        Int,
    val nombre:    String,
    val precio:    Double,
    val categoria: String,
    val stock:     Int,
    val activo:    Boolean = true
)

// Producto de la API — mapea el JSON de los pasos 5 y 6
data class ProductoApi(
    val id:            Int,
    val name:          String,
    val slug:          String,
    val price:         String,
    val stock:         Int,
    val is_active:     Boolean,
    val url_image:     String,
    val category_name: String
)

data class PaginatedResponse(
    val count:    Int,
    val next:     String?,
    val previous: String?,
    val results:  List<ProductoApi>
)

// Datos locales de muestra para los primeros pasos
val productosDeMuestra = listOf(
    Producto(1, "Samsung Galaxy S25",   899.99,  "Gama Alta",    15),
    Producto(2, "iPhone 16",            1099.99, "Gama Alta",    8),
    Producto(3, "Xiaomi Redmi Note 14", 299.99,  "Gama Media",   42, activo = false),
    Producto(4, "Google Pixel 9",       799.99,  "Gama Alta",    23),
    Producto(5, "Motorola Edge 50",     449.99,  "Gama Media",   11),
    Producto(6, "Samsung Galaxy A55",   379.99,  "Gama Media",   30),
    Producto(7, "iPhone 15",            799.99,  "Gama Alta",    19),
    Producto(8, "Xiaomi 14T",           499.99,  "Gama Media",   55),
)