package com.ute.shopmovilesdiaz.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ute.shopmovilesdiaz.presentation.ui.cart.CartScreen
import com.ute.shopmovilesdiaz.presentation.ui.catalog.CatalogScreen
import com.ute.shopmovilesdiaz.presentation.ui.detail.DetailScreen
import com.ute.shopmovilesdiaz.presentation.viewmodel.CartViewModel
import com.ute.shopmovilesdiaz.theme.Background

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val cartViewModel: CartViewModel = viewModel()

    Scaffold(
        containerColor = Background,
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Catalog.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Screen.Catalog.route) {
                CatalogScreen(
                    onDetailClick = { id -> navController.navigate(Screen.Detail(id).createRoute(id)) },
                    cartViewModel = cartViewModel,
                )
            }

            composable(
                route = Screen.Detail().route,
                arguments = listOf(navArgument("id") { type = NavType.IntType }),
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id") ?: return@composable
                DetailScreen(
                    celularId = id,
                    onBack = { navController.popBackStack() },
                    cartViewModel = cartViewModel,
                    snackbarHostState = snackbarHostState,
                )
            }

            composable(Screen.Cart.route) {
                CartScreen(
                    cartViewModel = cartViewModel,
                    snackbarHostState = snackbarHostState,
                )
            }
        }
    }
}
