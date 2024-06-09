package com.pieterv.modernmonsters.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.pieterv.list.ListScreenRoute
import com.pieterv.list.navigation.ListScreenRoute

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> {
            ListScreenRoute(onPokemonTap = { pokemonId ->
                navController.navigate(
                    PokemonDetailScreen(
                        pokemonId = pokemonId
                    )
                )
            })
        }

        composable<PokemonDetailScreen> {
            val args = it.toRoute<PokemonDetailScreen>()
            Column {

            }
        }
    }
}

@kotlinx.serialization.Serializable
data class PokemonDetailScreen(
    val pokemonId: Int,
)