package com.codingguide.jetpackcomposeapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = Purple40,
    primaryVariant = Purple80,
    secondary = Color.Gray
)

private val LightColorPalette = lightColors(
    primary = Purple40,
    primaryVariant = Purple80,
    secondary = Color.Gray
)

@Composable
fun JetpackComposeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val view = LocalView.current
    val context = LocalContext.current
    if (!view.isInEditMode) {
        SideEffect {
            (context as? Activity)?.let { activity ->
                activity.window?.let { window ->
                    window.statusBarColor = colors.primary.toArgb()
                    WindowCompat.getInsetsController(window, view)?.isAppearanceLightStatusBars = !darkTheme
                }
            }
        }
    }
    MaterialTheme(
        colors = colors,
        content = content
    )
}
