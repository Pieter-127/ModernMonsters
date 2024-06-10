package com.pieterv.database.pokemon

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pieterv.database.model.PokedexListEntryEntity

@Database(
    entities = [PokedexListEntryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PokemonDb : RoomDatabase() {
    abstract fun pokemonListDao(): PokemonListDao
}