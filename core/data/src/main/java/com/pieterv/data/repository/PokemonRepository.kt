package com.pieterv.data.repository

import androidx.paging.PagingData
import com.pieterv.common.Resource
import com.pieterv.data.repository.model.PokemonListEntry
import com.pieterv.network.model.PokemonDto
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonPagingData(initialPageSize: Int): Resource<Flow<PagingData<PokemonListEntry>>>

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDto>

}