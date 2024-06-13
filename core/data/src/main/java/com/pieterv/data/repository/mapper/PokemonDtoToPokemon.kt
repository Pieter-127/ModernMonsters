package com.pieterv.data.repository.mapper

import com.pieterv.models.PokemonDetail
import com.pieterv.network.model.PokemonDto

fun PokemonDto.toPokemonDetail(): PokemonDetail {
    return PokemonDetail(
        foundInGames = this.games.map {
            it.version.name
        }
    )
}