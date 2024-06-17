package com.pieterv.data.repository.impl

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pieterv.common.Resource
import com.pieterv.data.repository.PokemonRepository
import com.pieterv.data.repository.mapper.toPokemonDetail
import com.pieterv.data.repository.paging.PokemonPagingSource
import com.pieterv.models.PokemonDetail
import com.pieterv.models.PokemonListEntry
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

    override suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDetail> {
        return try {
            Resource.Success(
                api.getPokemonInfo(pokemonName.toLowerCase(Locale.current)).toPokemonDetail()
            )
        } catch (e: Exception) {
            return Resource.Error(e)
        }
    }
}
