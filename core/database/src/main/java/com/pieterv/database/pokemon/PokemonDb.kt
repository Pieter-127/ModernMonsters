package com.pieterv.database.pokemon

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pieterv.database.model.PokedexListEntry

@Database(
    entities = [PokedexListEntry::class],
    version = 1,
    exportSchema = false
)
abstract class PokemonDb : RoomDatabase() {
    abstract fun pokemonListDao(): PokemonListDao
}