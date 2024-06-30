package com.pieterv.types

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pieterv.models.Matchup
import com.pieterv.types.components.MatchupEntry

@Composable
fun MatchupScreen(
    modifier: Modifier = Modifier,
    onMatchupTap: (Matchup) -> Unit,
    viewModel: PokemonTypesViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadMatchups()
    }

    MatchupScreenContent(
        modifier = modifier,
        state = viewModel.state.collectAsStateWithLifecycle().value,
        onMatchupTap = onMatchupTap
    )
}

@Composable
private fun MatchupScreenContent(
    modifier: Modifier = Modifier,
    state: MatchupsState,
    onMatchupTap: (Matchup) -> Unit,
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
                MatchupList(
                    entries = state.matchups,
                    onMatchupTap = onMatchupTap
                )
            }
        }
    }
}

@Composable
private fun MatchupList(
    modifier: Modifier = Modifier,
    entries: List<Matchup>,
    onMatchupTap: (Matchup) -> Unit
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2)) {
        items(
            count = entries.size,
        ) { index ->
            val item = entries[index]
            MatchupEntry(entry = item, onMatchupTap = onMatchupTap)
        }
    }
}


@Preview
@Composable
private fun PokemonTypesPreview() {
    MatchupScreenContent(
        modifier = Modifier.fillMaxSize(),
        state = MatchupsState(
            isLoading = false,
            failedLoading = false,
            matchups = arrayListOf(
                Matchup.FIRE,
                Matchup.GRASS,
                Matchup.WATER
            )
        )
    ) {

    }
}