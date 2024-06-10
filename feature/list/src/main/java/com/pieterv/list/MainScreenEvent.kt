package com.pieterv.list

import com.pieterv.models.PokemonListEntry


sealed class MainScreenEvent {
    data object LoadPokemon : MainScreenEvent()
    data class PokedexTap(val pokemon: PokemonListEntry) : MainScreenEvent()
}