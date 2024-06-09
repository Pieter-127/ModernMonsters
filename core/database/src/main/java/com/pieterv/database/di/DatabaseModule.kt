package com.pieterv.database.di

import android.content.Context
import androidx.room.Room
import com.pieterv.database.pokemon.PokemonDb
import com.pieterv.database.pokemon.PokemonListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext appContext: Context): PokemonDb {
        return Room.databaseBuilder(
            appContext,
            PokemonDb::class.java,
            "pokemon_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providePokedexTable(db: PokemonDb): PokemonListDao {
        return db.pokemonListDao()
    }
}