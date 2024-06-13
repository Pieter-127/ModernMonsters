package com.pieterv.data.repository

import androidx.paging.PagingData
import com.pieterv.common.Resource
import com.pieterv.models.PokemonDetail
import com.pieterv.models.PokemonListEntry
import com.pieterv.network.model.PokemonDto
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonPagingData(initialPageSize: Int): Resource<Flow<PagingData<PokemonListEntry>>>

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDetail>

}