package com.pieterv.modernmonsters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pieterv.modernmonsters.navigation.PokemonListNavigation
import com.pieterv.design.theme.ModernMonstersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernMonstersTheme {
               ModernMonstersUI()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ModernMonstersTheme {
      PokemonListNavigation()
    }
}