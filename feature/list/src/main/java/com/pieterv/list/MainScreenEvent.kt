package com.pieterv.list


sealed class MainScreenEvent {
    data object LoadPokemon : MainScreenEvent()
//    data class PokedexTap(val pokemon: PokedexListEntry) : MainScreenEvent()
}