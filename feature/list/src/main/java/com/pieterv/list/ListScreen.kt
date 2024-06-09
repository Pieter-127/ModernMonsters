package com.pieterv.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
 fun ListScreenRoute(
    onPokemonTap: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel = hiltViewModel(),
) {
//    val screenState by viewModel.feedUiState.collectAsStateWithLifecycle()
    ListScreenContent()
}

@Composable
internal fun ListScreenContent() {
    Column {
        Text("Hello from pokemon list on sunday")
    }
}