package com.ute.shopmovilesdiaz.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ute.shopmovilesdiaz.theme.Accent
import com.ute.shopmovilesdiaz.theme.AccentOnDark

@Composable
fun ShopButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled && !isLoading,
        modifier = modifier.fillMaxWidth().height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Accent,
            contentColor = AccentOnDark,
            disabledContainerColor = Accent.copy(alpha = 0.4f),
            disabledContentColor = AccentOnDark.copy(alpha = 0.4f),
        ),
        shape = MaterialTheme.shapes.medium,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = AccentOnDark,
                modifier = Modifier.size(18.dp),
                strokeWidth = 2.dp,
            )
            Spacer(Modifier.width(8.dp))
        }
        Text(text = if (isLoading) "Cargando..." else text)
    }
}
