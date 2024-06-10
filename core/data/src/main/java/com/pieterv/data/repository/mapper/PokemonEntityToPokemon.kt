package com.pieterv.data.repository.mapper

import com.pieterv.data.repository.model.PokemonListEntry
import com.pieterv.database.model.PokedexListEntryEntity

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