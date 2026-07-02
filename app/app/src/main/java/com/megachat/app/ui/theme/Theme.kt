package com.megachat.app.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = PeachVibrant,
    onPrimary = TextPrimary,
    primaryContainer = Peach,
    onPrimaryContainer = TextPrimary,
    secondary = MintDark,
    onSecondary = TextPrimary,
    secondaryContainer = Mint,
    onSecondaryContainer = TextPrimary,
    tertiary = LavenderDark,
    onTertiary = TextPrimary,
    tertiaryContainer = Lavender,
    onTertiaryContainer = TextPrimary,
    background = Cream,
    onBackground = TextPrimary,
    surface = White,
    onSurface = TextPrimary,
    surfaceVariant = LightGray,
    onSurfaceVariant = TextSecondary,
    outline = WarmGrayLight
)

@Composable
fun MegachatTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = PeachDark.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
