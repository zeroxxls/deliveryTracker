// ui/theme/Theme.kt
package com.example.deliverytracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Purple200,
    onPrimary = White,
    secondary = Teal200
)

private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    onPrimary = Black,
    secondary = Teal200
)

@Composable
fun DeliveryTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
