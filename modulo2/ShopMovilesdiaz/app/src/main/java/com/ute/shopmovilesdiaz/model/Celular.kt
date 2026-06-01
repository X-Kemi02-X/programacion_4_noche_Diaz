package com.ute.shopmovilesdiaz.model

data class Celular(
    val id: Int,
    val marca: String,
    val modelo: String,
    val precio: Double,
    val descripcion: String,
    val especificaciones: String,
    val stock: Int,
    val imagenUrl: String = "",
    val destacado: Boolean = false,
)
