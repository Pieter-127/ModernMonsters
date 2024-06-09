package com.pieterv.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.pieterv.design.theme.ModernMonstersTheme

@Composable
fun ListScreen(
    onPokemonTap: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel = hiltViewModel(),
) {
//    val screenState by viewModel.feedUiState.collectAsStateWithLifecycle()
    ModernMonstersTheme {
        ListScreenContent()
    }
}

@Composable
internal fun ListScreenContent() {
    Column {
        Text("design system")
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    ModernMonstersTheme {
        ListScreenContent()
    }
}