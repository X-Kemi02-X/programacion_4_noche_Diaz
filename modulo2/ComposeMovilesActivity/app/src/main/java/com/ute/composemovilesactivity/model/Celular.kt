package com.ute.composemovilesactivity.model

data class Celular(
    val id: Int,
    val marca: String,
    val modelo: String,
    val precio: Double,
    val descripcion: String,
    val stock: Int,
    val destacado: Boolean = false,
    val favorito: Boolean = false,
)

val celularesDeMuestra = listOf(
    Celular(1, "Samsung",  "Galaxy S24 Ultra",   1299.99, "Pantalla Dynamic AMOLED 2X, 256GB, 12GB RAM", 15, destacado = true),
    Celular(2, "Apple",    "iPhone 16 Pro Max",   1499.99, "Chip A18 Pro, 256GB, Titanio natural",         8, destacado = true),
    Celular(3, "Xiaomi",   "Redmi Note 13 Pro",   399.99,  "Cámara 200MP, 512GB, 8GB RAM",                42),
    Celular(4, "Motorola", "Edge 50 Pro",         599.99,  "Pantalla pOLED 6.7\", 256GB, 12GB RAM",       23),
    Celular(5, "Samsung",  "Galaxy A55 5G",       349.99,  "Exynos 1480, 128GB, 6GB RAM",                30),
    Celular(6, "Apple",    "iPhone 16",           799.99,  "Chip A18, 128GB, Sistema de cámara dual",    11),
    Celular(7, "Xiaomi",   "Xiaomi 14T Pro",      649.99,  "Dimensity 9300+, 512GB, 12GB RAM",            19, destacado = true),
    Celular(8, "Motorola", "Moto G84 5G",         279.99,  "Snapdragon 695, 256GB, 8GB RAM",              55),
    Celular(9, "Samsung",  "Galaxy Z Fold6",     1899.99, "Pantalla plegable 7.6\", 512GB, 12GB RAM",     5, destacado = true),
    Celular(10, "Apple",   "iPhone 15",           699.99,  "Chip A16 Bionic, 128GB, USB-C",               0),
)
