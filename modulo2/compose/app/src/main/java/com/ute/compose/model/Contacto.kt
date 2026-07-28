// model/Contacto.kt
package com.ute.compose.model

data class Contacto(
    val id:        Int,
    val nombre:    String,
    val email:     String,
    val telefono:  String,
    val favorito:  Boolean = false
)

// Lista de muestra — la usamos en todos los pasos
val contactosDeMuestra = listOf(
    Contacto(1, "Samsung Galaxy S25",   "samsung@tienda.com", "$899",   favorito = true),
    Contacto(2, "iPhone 16",            "apple@tienda.com",   "$1099"),
    Contacto(3, "Xiaomi Redmi Note 14", "xiaomi@tienda.com",  "$299",   favorito = true),
    Contacto(4, "Google Pixel 9",       "google@tienda.com",  "$799"),
    Contacto(5, "Motorola Edge 50",     "moto@tienda.com",    "$449"),
    Contacto(6, "Samsung Galaxy A55",   "samsung@tienda.com", "$379"),
    Contacto(7, "iPhone 15",            "apple@tienda.com",   "$799",   favorito = true),
    Contacto(8, "Xiaomi 14T",           "xiaomi@tienda.com",  "$499"),
)