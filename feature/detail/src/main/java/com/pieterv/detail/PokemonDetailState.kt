package com.pieterv.detail

import com.pieterv.models.PokemonDetail

data class PokemonDetailState(
    var failedLoading: Boolean = false,
    var isLoading: Boolean = false,
    var data: PokemonDetail = PokemonDetail()
)