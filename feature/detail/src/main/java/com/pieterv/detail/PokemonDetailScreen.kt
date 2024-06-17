package com.pieterv.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.pieterv.components.MonstersTopAppBar
import com.pieterv.detail.components.LottieAnimation
import com.pieterv.detail.components.PokemonGamesComposable
import com.pieterv.detail.components.PokemonHeadingImage
import com.pieterv.detail.components.PokemonSpritesComposable
import com.pieterv.detail.components.PokemonStatsComposable
import com.pieterv.detail.components.PokemonTypesComposable
import com.pieterv.detail.navigation.DetailScreenRoute
import com.pieterv.models.PokemonName

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
        onRetry = { viewModel.loadPokemon(args.pokemonName) }
    )
}

@Composable
internal fun PokemonDetailScreenContent(
    modifier: Modifier = Modifier,
    state: PokemonDetailState,
    navController: NavController,
    pokemonName: PokemonName,
    pokemonImageUrl: String,
    onRetry: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Scaffold(
            modifier = modifier,
            topBar = { MonstersTopAppBar(navController = navController, title = pokemonName) },
            content = { paddingValues ->
                if (state.isLoading) {
                    ScreenLoadingComposable(
                        Modifier
                            .padding(start = 4.dp, end = 4.dp)
                            .fillMaxSize()
                    )
                } else if (state.failedLoading) {
                    LoadingFailedComposable(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        onRetry = onRetry
                    )
                } else {
                    ScreenLoadedComposable(
                        paddingValues,
                        pokemonImageUrl,
                        pokemonName,
                        modifier,
                        state
                    )
                }
            })
    }
}

@Composable
private fun ScreenLoadingComposable(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            file = R.raw.anim,
            isPlaying = true
        )
    }
}

@Composable
private fun LoadingFailedComposable(
    modifier: Modifier,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.generic_error))
        Button(
            modifier = Modifier.padding(top = 4.dp),
            onClick = { onRetry.invoke() }) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }
}

@Composable
private fun ScreenLoadedComposable(
    paddingValues: PaddingValues,
    pokemonImageUrl: String,
    pokemonName: PokemonName,
    modifier: Modifier,
    state: PokemonDetailState
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        item {
            PokemonHeadingImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                pokemonImageUrl = pokemonImageUrl,
                pokemonName = pokemonName
            )
        }
        item {
            PokemonTypesComposable(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                types = state.data.types
            )
        }
        item {
            PokemonStatsComposable(
                modifier = Modifier.padding(
                    start = 8.dp,
                    top = 8.dp
                ),
                baseStats = state.data.baseStats
            )
        }
        item {
            PokemonSpritesComposable(sprites = state.data.sprites)
        }
        item {
            PokemonGamesComposable(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp
                    ),
                games = state.data.foundInGames
            )
        }
    }
}