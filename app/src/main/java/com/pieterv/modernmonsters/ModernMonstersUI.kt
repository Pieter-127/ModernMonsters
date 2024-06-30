package com.pieterv.modernmonsters

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.pieterv.modernmonsters.navigation.AppDestinations
import com.pieterv.modernmonsters.navigation.PokemonListNavigation
import com.pieterv.modernmonsters.navigation.MatchupNavigation

@Composable
fun ModernMonstersUI() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    val colors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.secondary,
            selectedIconColor = MaterialTheme.colorScheme.onPrimary
        )
    )

    NavigationSuiteScaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onPrimary,
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
                    onClick = { currentDestination = it },
                    colors = colors
                )

            }
        }
    ) {
        when (currentDestination) {
            AppDestinations.HOME -> {
                PokemonListNavigation()
            }

            AppDestinations.TYPES -> {
                MatchupNavigation()
            }
        }
    }
}