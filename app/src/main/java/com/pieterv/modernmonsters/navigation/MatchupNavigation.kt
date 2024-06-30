package com.pieterv.modernmonsters.navigation

import android.os.Build
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.pieterv.detail.navigation.DetailScreenRoute
import com.pieterv.models.Matchup
import com.pieterv.typeinfo.TypeInfoScreen
import com.pieterv.typeinfo.navigation.TypeInfoScreenNavigation
import com.pieterv.types.MatchupScreen
import com.pieterv.types.navigation.MatchupScreenRoute
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

@Composable
fun MatchupNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MatchupScreenRoute) {
        composable<MatchupScreenRoute> {
            MatchupScreen(
                modifier = Modifier.fillMaxSize(),
                onMatchupTap = { matchup ->
                    navController.navigate(
                        TypeInfoScreenNavigation(
                            matchup = matchup
                        )
                    )
                })
        }

        composable<TypeInfoScreenNavigation>(
            typeMap = mapOf(typeOf<Matchup>() to matchupType)
        ) {
            val args = it.toRoute<TypeInfoScreenNavigation>()
            TypeInfoScreen(
                modifier = Modifier.fillMaxSize(),
                args = args,
                navController = navController
            )
        }
    }
}


private val matchupType = object : NavType<Matchup>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): Matchup? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Matchup::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): Matchup {
        return Json.decodeFromString<Matchup>(value)
    }

    override fun serializeAsValue(value: Matchup): String {
        return Json.encodeToString(value)
    }

    override fun put(bundle: Bundle, key: String, value: Matchup) {
        bundle.putParcelable(key, value)
    }
}