package com.pieterv.data.repository.di

import com.pieterv.data.repository.PokemonRepository
import com.pieterv.data.repository.impl.TypeInfoFactory
import com.pieterv.data.repository.impl.PokemonRepositoryImpl
import com.pieterv.data.repository.paging.PokemonPagingSource
import com.pieterv.database.pokemon.PokemonListDao
import com.pieterv.network.retrofit.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun providePokemonPagingSource(
        api: PokemonApi,
        pokemonListDao: PokemonListDao
    ): PokemonPagingSource {
        return PokemonPagingSource(api, pokemonListDao)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokemonApi,
        pokemonPagingSource: PokemonPagingSource,
        typeInfoFactory: TypeInfoFactory,
    ): PokemonRepository {
        return PokemonRepositoryImpl(api, pokemonPagingSource, typeInfoFactory)
    }

    @Provides
    @Singleton
    fun provideMatchupInfoFactory(
    ): TypeInfoFactory {
        return TypeInfoFactory()
    }
}