package com.pieterv.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.pieterv.design.theme.ModernMonstersTheme
import kotlinx.coroutines.flow.flowOf
import com.pieterv.list.components.*
import com.pieterv.models.PokemonListEntry
import com.pieterv.models.PokemonName


@Composable
fun ListScreen(
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
        onPokemonTap = onPokemonTap
    )
}

@Preview
@Composable
private fun PokemonListPreview() {
    ListScreenContent(Modifier.fillMaxSize(), MainScreenState()) {}
}

@Composable
private fun ListScreenContent(
    modifier: Modifier = Modifier,
    state: MainScreenState,
    entries: LazyPagingItems<PokemonListEntry> = flowOf(PagingData.empty<PokemonListEntry>()).collectAsLazyPagingItems(),
    onPokemonTap: (PokemonListEntry) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (state.failedLoading) {
                //todo add failed loading state
            } else {
                PokemonList(pokedexEntries = entries, onPokemonTap = onPokemonTap)
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