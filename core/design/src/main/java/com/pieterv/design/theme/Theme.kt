package com.pieterv.design.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryRed,
    secondary = SecondaryRed,
    tertiary = Tertiary,
    background = LightGray,
    onPrimary = Black,
)

@Composable
fun ModernMonstersTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}