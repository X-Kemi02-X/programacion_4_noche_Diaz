package com.ute.shopmovilesdiaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ute.shopmovilesdiaz.presentation.navigation.NavGraph
import com.ute.shopmovilesdiaz.theme.ShopMovilesdiazTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopMovilesdiazTheme {
                NavGraph()
            }
        }
    }
}
