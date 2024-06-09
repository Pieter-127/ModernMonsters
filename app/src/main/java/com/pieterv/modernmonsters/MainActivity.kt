package com.pieterv.modernmonsters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pieterv.list.ListScreenRoute
import com.pieterv.modernmonsters.navigation.Navigation
import com.pieterv.modernmonsters.ui.theme.ModernMonstersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModernMonstersTheme {
                Navigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModernMonstersTheme {
        ListScreenRoute(
            onPokemonTap = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}