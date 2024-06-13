package com.pieterv.modernmonsters.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.pieterv.detail.PokemonDetailScreen
import com.pieterv.detail.navigation.DetailScreenRoute
import com.pieterv.list.PokemonListScreen
import com.pieterv.list.navigation.ListScreenRoute

@Composable
fun PokemonListNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> {
            PokemonListScreen(
                modifier = Modifier.fillMaxSize(),
                onPokemonTap = { pokemon ->
                    navController.navigate(
                        DetailScreenRoute(
                            pokemonName = pokemon.pokemonName,
                            imageUrl = pokemon.imageUrl
                        )
                    )
                })
        }
        composable<DetailScreenRoute> {
            val args = it.toRoute<DetailScreenRoute>()
            PokemonDetailScreen(
                modifier = Modifier.fillMaxSize(),
                args = args,
                navController = navController
            )
        }
    }
}