package me.lgcode.agepedia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PrimaryColorPalette = lightColors(
        primary = indigo,
        primaryVariant = darkindigo,
        secondary = orange,
        secondaryVariant = coral,
        background = Color.White,
        surface = lightgary,
        onSurface = black,
        onError = red
)

@Composable
fun AgePediaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = PrimaryColorPalette

    MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
    )
}