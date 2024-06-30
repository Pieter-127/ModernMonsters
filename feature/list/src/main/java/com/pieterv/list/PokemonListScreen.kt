package com.pieterv.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.pieterv.components.MonstersLottieAnimation
import kotlinx.coroutines.flow.flowOf
import com.pieterv.list.components.*
import com.pieterv.models.PokemonListEntry

@Composable
fun PokemonListScreen(
    onPokemonTap: (PokemonListEntry) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadPokemon()
    }

    ListScreenContent(
        modifier = modifier,
        state = viewModel.state.collectAsStateWithLifecycle().value,
        entries = viewModel.pokedexEntries.collectAsLazyPagingItems(),
        onPokemonTap = onPokemonTap,
        onRetry = {
            viewModel.loadPokemon()
        }
    )
}

@Preview
@Composable
private fun PokemonListPreview() {
    ListScreenContent(
        modifier = Modifier.fillMaxSize(),
        state = MainScreenState(),
        entries = flowOf(PagingData.from(listOf(PokemonListEntry("Test","","#001"),
            PokemonListEntry("Test","","#002")))).collectAsLazyPagingItems(),
        onRetry = {

        },
        onPokemonTap = {

        }
    )
}

@Composable
private fun ListScreenContent(
    modifier: Modifier = Modifier,
    state: MainScreenState,
    entries: LazyPagingItems<PokemonListEntry> = flowOf(PagingData.empty<PokemonListEntry>()).collectAsLazyPagingItems(),
    onPokemonTap: (PokemonListEntry) -> Unit,
    onRetry: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Column(
            modifier = modifier
        ) {
            if (state.failedLoading) {
                LoadingFailedComposable(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    onRetry = onRetry
                )
            } else if (state.isLoading) {
                MonstersLottieAnimation(file = R.raw.anim, isPlaying = true)
            } else {
                PokemonList(
                    pokedexEntries = entries, onPokemonTap = onPokemonTap
                )
            }
        }
    }
}

@Composable
private fun PokemonList(
    modifier: Modifier = Modifier,
    pokedexEntries: LazyPagingItems<PokemonListEntry>,
    onPokemonTap: (PokemonListEntry) -> Unit
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2)) {
        items(
            count = pokedexEntries.itemCount,
            key = pokedexEntries.itemKey { it.number },
        ) { index ->
            val item = pokedexEntries[index]
            if (item != null) {
                PokedexEntry(entry = item, onPokemonTap = onPokemonTap)
            }
        }
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