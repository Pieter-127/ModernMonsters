package com.pieterv.database.pokemon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pieterv.database.model.PokedexListEntryEntity

@Dao
interface PokemonListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokedexListEntryEntity>)

    @Query("SELECT * FROM pokedex LIMIT :pageSize OFFSET :offset")
    suspend fun getPokemonRange(pageSize: Int, offset: Int): List<PokedexListEntryEntity>

}