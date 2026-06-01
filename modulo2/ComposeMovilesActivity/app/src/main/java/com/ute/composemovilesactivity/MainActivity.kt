package com.ute.composemovilesactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ute.composemovilesactivity.ui.screens.ComposeMovilesScreen
import com.ute.composemovilesactivity.ui.theme.ComposeMovilesActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMovilesActivityTheme {
                ComposeMovilesScreen()
            }
        }
    }
}
