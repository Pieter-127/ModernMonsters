package com.pieterv.models

data class PokemonDetail(
    val baseStats: Int = 0,
    val foundInGames: List<String> = listOf(),
    val types: List<String> = listOf(),
    val sprites: List<String> = listOf(),
)