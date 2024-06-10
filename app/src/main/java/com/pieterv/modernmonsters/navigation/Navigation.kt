package com.pieterv.modernmonsters.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pieterv.list.ListScreen
import com.pieterv.list.navigation.ListScreenRoute

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> {
            ListScreen(
                modifier = Modifier.fillMaxSize(),
                onPokemonTap = { pokemonId ->
                    navController.navigate(
                        PokemonDetailScreen(
                            pokemonId = pokemonId
                        )
                    )
                })
        }
    }
}

@kotlinx.serialization.Serializable
data class PokemonDetailScreen(
    val pokemonId: Int,
)