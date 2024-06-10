package com.pieterv.domain.impl

import androidx.paging.PagingData
import com.pieterv.common.Resource
import com.pieterv.data.repository.PokemonRepository
import com.pieterv.data.repository.model.PokemonListEntry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
)  {
    suspend operator fun invoke(initialPageSize: Int): Resource<Flow<PagingData<PokemonListEntry>>> {
        return pokemonRepository.getPokemonPagingData(initialPageSize)
    }
}