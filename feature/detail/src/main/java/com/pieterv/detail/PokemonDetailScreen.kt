package com.pieterv.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pieterv.components.ImageLoadingComposable
import com.pieterv.components.MonstersTopAppBar
import com.pieterv.detail.components.PokemonTypesComposable
import com.pieterv.detail.navigation.DetailScreenRoute
import com.pieterv.models.PokemonListEntry
import com.pieterv.models.PokemonName
import kotlinx.coroutines.flow.flowOf

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    args: DetailScreenRoute,
    navController: NavController,
    viewModel: PokemonDetailScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadPokemon(args.pokemonName)
    }

    PokemonDetailScreenContent(
        modifier = modifier,
        state = viewModel.state.collectAsStateWithLifecycle().value,
        navController = navController,
        pokemonName = args.pokemonName,
        pokemonImageUrl = args.imageUrl,
    )
}

@Composable
internal fun PokemonDetailScreenContent(
    modifier: Modifier = Modifier,
    state: PokemonDetailState,
    navController: NavController,
    pokemonName: PokemonName,
    pokemonImageUrl: String
) {
    Scaffold(
        modifier = modifier,
        topBar = { MonstersTopAppBar(navController = navController, title = pokemonName) },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            ImageLoadingComposable(
                                modifier = Modifier.size(160.dp),
                                imageUrl = pokemonImageUrl,
                                contentDescription = pokemonName,
                                loadingAnimation = {
                                    CircularProgressIndicator()
                                }
                            )
                        }
                    }
                }
            }
        })
}