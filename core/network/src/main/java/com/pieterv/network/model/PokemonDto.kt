package com.pieterv.network.model

import com.squareup.moshi.Json

data class PokemonDto(
    val id: Int,
    val name: String,
    @field:Json(name = "game_indices")
    val games: List<Game>,
    val sprites: Sprites,
    val stats: List<StatInfo>,
    val types: List<PokemonTypeInfo>
)

data class PokemonTypeInfo(val type: PokemonType)
data class PokemonType(val name: String)

data class StatInfo(
    @field:Json(name = "base_stat")
    val base: Int
)

data class Game(
    @field:Json(name = "game_index")
    val gameIndex: Int,
    val version: Version
)

data class Version(
    val name: String,
    val url: String
)

data class Sprites(
    @field:Json(name = "front_default")
    val frontDefault: String?,
    @field:Json(name = "back_default")
    val backDefault: String?,
    @field:Json(name = "front_female")
    val frontFemale: String?,
    @field:Json(name = "back_female")
    val backFemale: String?,
    @field:Json(name = "front_shiny")
    val frontShiny: String?,
    @field:Json(name = "back_shiny")
    val backShiny: String?,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: String?,
)
