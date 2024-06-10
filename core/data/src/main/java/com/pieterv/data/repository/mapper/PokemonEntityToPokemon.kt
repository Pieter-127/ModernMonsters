package com.pieterv.data.repository.mapper

import com.pieterv.database.model.PokedexListEntryEntity
import com.pieterv.models.PokemonListEntry

fun List<PokedexListEntryEntity>.toPokedexEntry(): List<PokemonListEntry> {
    val mappedData = this.map {
        PokemonListEntry(
            pokemonName = it.pokemonName,
            imageUrl = it.imageUrl,
            number = it.number
        )
    }.toList()

    return mappedData
}