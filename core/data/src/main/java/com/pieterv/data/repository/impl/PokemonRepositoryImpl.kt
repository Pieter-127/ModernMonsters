package com.pieterv.data.repository.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pieterv.common.Resource
import com.pieterv.data.repository.PokemonRepository
import com.pieterv.data.repository.model.PokemonListEntry
import com.pieterv.data.repository.paging.PokemonPagingSource
import com.pieterv.network.model.PokemonDto
import com.pieterv.network.retrofit.PokemonApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val pokemonPagingSource: PokemonPagingSource,
) : PokemonRepository {

    override suspend fun getPokemonPagingData(initialPageSize: Int): Resource<Flow<PagingData<PokemonListEntry>>> {
        return Resource.Success(
            Pager(config = PagingConfig(
            pageSize = initialPageSize,
            enablePlaceholders = true
        ),
            pagingSourceFactory = { pokemonPagingSource }).flow
        )
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDto> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(e)
        }
        return Resource.Success(response)
    }
}
