package com.pieterv.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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

@Composable
fun ListScreen(
    onPokemonTap: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel = hiltViewModel(),
) {
    ModernMonstersTheme {
        ListScreenContent(
            modifier,
            viewModel.state.collectAsStateWithLifecycle().value,
            viewModel.pokedexEntries.collectAsLazyPagingItems()
        ) {
            viewModel.onEvent(it)
        }

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(MainScreenEvent.LoadPokemon)
        }
    }
}

@Preview
@Composable
fun PokemonListPreview() {
    ListScreenContent(Modifier.fillMaxSize(), MainScreenState()) {}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreenContent(
    modifier: Modifier = Modifier,
    state: MainScreenState,
    entries: LazyPagingItems<PokemonListEntry> = flowOf(PagingData.empty<PokemonListEntry>()).collectAsLazyPagingItems(),
    onScreenEvent: (MainScreenEvent) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.appBarTitle),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                )
            }) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (state.failedLoading) {
                        //todo add failed loading state
                    } else {
                        PokemonList(pokedexEntries = entries, event = onScreenEvent)
                    }
                }
            }
        }
    }
}

@Composable
private fun PokemonList(
    modifier: Modifier = Modifier,
    pokedexEntries: LazyPagingItems<PokemonListEntry>,
    event: (MainScreenEvent) -> Unit
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2)) {
        items(
            count = pokedexEntries.itemCount,
            key = pokedexEntries.itemKey { it.number },
        ) { index ->
            val item = pokedexEntries[index]
            if (item != null) {
                PokedexEntry(entry = item, event = event)
            }
        }
    }
}