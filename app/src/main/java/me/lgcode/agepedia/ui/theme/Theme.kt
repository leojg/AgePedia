package me.lgcode.agepedia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PrimaryColorPalette = lightColors(
    primary = orange,
    primaryVariant = brick,
    secondary = blue,
    secondaryVariant = darkBlue,
    background = Color.White,
    surface = Color.LightGray
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