package com.pieterv.typeinfo.navigation

import com.pieterv.models.Matchup

@kotlinx.serialization.Serializable
data class TypeInfoScreenNavigation(
    val matchup: Matchup,
)