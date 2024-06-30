package com.pieterv.typeinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.pieterv.common.formatToDisplayCase
import com.pieterv.components.MonstersLottieAnimation
import com.pieterv.components.MonstersTopAppBar
import com.pieterv.typeinfo.navigation.TypeInfoScreenNavigation

@Composable
fun TypeInfoScreen(
    modifier: Modifier = Modifier,
    args: TypeInfoScreenNavigation,
    navController: NavController,
    viewModel: TypeInfoViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadInfoForMatchup(args.matchup)
    }

    MatchupDetailScreenContent(
        modifier = modifier,
        state = viewModel.state.collectAsStateWithLifecycle().value,
        navController = navController,
        toolbarHeading = args.matchup.name.formatToDisplayCase(),
        onRetry = { viewModel.loadInfoForMatchup(args.matchup) }
    )
}

@Composable
internal fun MatchupDetailScreenContent(
    modifier: Modifier = Modifier,
    state: TypeInfoState,
    navController: NavController,
    toolbarHeading: String,
    onRetry: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Scaffold(
            modifier = modifier,
            topBar = { MonstersTopAppBar(navController = navController, title = toolbarHeading) },
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
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        state = state
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
        MonstersLottieAnimation(
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
    modifier: Modifier,
    state: TypeInfoState
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(state.data?.typeStory ?: "")
        }
    }
}