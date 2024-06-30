package com.pieterv.types

import com.pieterv.models.Matchup

data class MatchupsState(
    var failedLoading: Boolean = false,
    var isLoading: Boolean = false,
    var matchups: List<Matchup> = listOf()
)