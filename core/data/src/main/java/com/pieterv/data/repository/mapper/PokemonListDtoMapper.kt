package com.pieterv.data.repository.mapper

import com.pieterv.database.model.PokedexListEntryEntity
import com.pieterv.network.model.PokemonListDto
import com.pieterv.network.model.*
import java.util.Locale

fun PokemonListDto.toPokedexEntry(): ArrayList<PokedexListEntryEntity> {
    val pokedexEntries = results.map { entry ->
        val pokemonNumber = determinePokemonNumber(entry)
        val displayNumber = formatNumber(pokemonNumber)
        val url = formatImageUrl(pokemonNumber)
        val name = formatName(entry)
        PokedexListEntryEntity(
            pokemonName = name,
            imageUrl = url,
            number = displayNumber
        )
    }
    return ArrayList(pokedexEntries)
}

private fun formatName(entry: Result) = entry.name.replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
}

private fun formatNumber(number: Int): String {
    //Format the number with leading zeroes if it's less than 100
    return String.format(Locale.ROOT, "#%03d", number)
}

private fun formatImageUrl(number: Int): String {
    val paddedNumber = String.format(Locale.ROOT, "%03d", number)
    return "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/$paddedNumber.png"
}

private fun determinePokemonNumber(entry: Result): Int {
    // Example URL from response = https://pokeapi.co/api/v2/pokemon/1/
    // Extract the number part from the URL
    return entry.url.split("/").lastOrNull { it.isNotEmpty() }?.toIntOrNull() ?: 0
}