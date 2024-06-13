package com.pieterv.models

data class PokemonDetail(
    val foundInGames: List<String> = arrayListOf(),
    val types: ArrayList<PokemonType> = arrayListOf()
)

enum class PokemonType {
    Normal, Fire, Water, Electric, Grass, Ice, Fighting, Poison, Ground,
    Flying, Psychic, Bug, Rock, Ghost, Dragon, Dark, Steel, Fairy
}