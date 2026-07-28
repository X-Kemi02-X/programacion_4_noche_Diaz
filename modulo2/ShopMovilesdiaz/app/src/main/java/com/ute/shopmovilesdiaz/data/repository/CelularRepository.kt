package com.ute.shopmovilesdiaz.data.repository

import com.ute.shopmovilesdiaz.model.Celular

object CelularRepository {

    private val celulares = listOf(
        Celular(1, "Samsung",  "Galaxy S24 Ultra",      1299.99, "Pantalla Dynamic AMOLED 2X, 256GB, 12GB RAM", "6.8\" AMOLED, 200MP Cámara, S Pen, IP68", 15, destacado = true),
        Celular(2, "Apple",    "iPhone 16 Pro Max",      1499.99, "Chip A18 Pro, 256GB, Titanio natural",        "6.9\" Super Retina XDR, 48MP Cámara, USB-C", 8, destacado = true),
        Celular(3, "Xiaomi",   "Redmi Note 13 Pro",      399.99,  "Cámara 200MP, 512GB, 8GB RAM",                "6.67\" AMOLED, 120Hz, 67W Carga rápida", 42),
        Celular(4, "Motorola", "Edge 50 Pro",            599.99,  "Pantalla pOLED 6.7\", 256GB, 12GB RAM",       "6.7\" pOLED, 50MP Cámara, IP68", 23),
        Celular(5, "Samsung",  "Galaxy A55 5G",          349.99,  "Exynos 1480, 128GB, 6GB RAM",                 "6.6\" Super AMOLED, 50MP Cámara, IP67", 30),
        Celular(6, "Apple",    "iPhone 16",              799.99,  "Chip A18, 128GB, Sistema de cámara dual",     "6.1\" Super Retina XDR, 48MP Cámara, USB-C", 11),
        Celular(7, "Xiaomi",   "Xiaomi 14T Pro",         649.99,  "Dimensity 9300+, 512GB, 12GB RAM",            "6.67\" AMOLED, 144Hz, 120W Carga rápida", 19, destacado = true),
        Celular(8, "Motorola", "Moto G84 5G",            279.99,  "Snapdragon 695, 256GB, 8GB RAM",              "6.5\" pOLED, 50MP Cámara, 5000mAh", 55),
        Celular(9, "Samsung",  "Galaxy Z Fold6",        1899.99, "Pantalla plegable 7.6\", 512GB, 12GB RAM",    "7.6\" Dynamic AMOLED, 200MP, S Pen, IP48", 5, destacado = true),
        Celular(10, "Apple",   "iPhone 15",              699.99,  "Chip A16 Bionic, 128GB, USB-C",               "6.1\" Super Retina XDR, 48MP Cámara, USB-C", 0),
    )

    fun obtenerTodos(): List<Celular> = celulares

    fun obtenerPorId(id: Int): Celular? = celulares.find { it.id == id }

    fun obtenerDestacados(): List<Celular> = celulares.filter { it.destacado }

    fun obtenerMarcas(): List<String> = celulares.map { it.marca }.distinct().sorted()
}
