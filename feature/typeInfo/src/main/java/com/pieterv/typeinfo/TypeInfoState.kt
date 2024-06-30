package com.pieterv.typeinfo

import com.pieterv.models.MatchupInfo

data class TypeInfoState(
    var failedLoading: Boolean = false,
    var isLoading: Boolean = false,
    var data: MatchupInfo? = null
)