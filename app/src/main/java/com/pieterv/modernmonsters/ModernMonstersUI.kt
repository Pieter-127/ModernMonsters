package com.pieterv.modernmonsters

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.pieterv.modernmonsters.navigation.AppDestinations
import com.pieterv.modernmonsters.navigation.PokemonListNavigation

@Composable
fun ModernMonstersUI() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = stringResource(it.contentDescription)
                        )
                    },
                    label = { Text(stringResource(it.label)) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )

            }
        }
    ) {
        when (currentDestination) {
            AppDestinations.HOME -> {
                PokemonListNavigation()
            }

            AppDestinations.SEARCH -> {

            }
        }
    }
}