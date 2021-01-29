package me.lgcode.agepedia.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PrimaryColorPalette = lightColors(
        primary = amber,
        primaryVariant = grose,
        secondary = orange,
        secondaryVariant = coral,
        background = Color.White,
        surface = Color.LightGray,
        onSurface = amber,
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