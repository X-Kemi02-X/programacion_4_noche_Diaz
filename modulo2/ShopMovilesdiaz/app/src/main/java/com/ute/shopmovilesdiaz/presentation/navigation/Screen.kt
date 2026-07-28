package com.ute.shopmovilesdiaz.presentation.navigation

sealed class Screen(val route: String) {
    data object Catalog : Screen("catalog")
    data class Detail(val id: Int = 0) : Screen("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    data object Cart : Screen("cart")
}
