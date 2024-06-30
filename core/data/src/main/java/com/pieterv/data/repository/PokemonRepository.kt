package com.pieterv.data.repository

import androidx.paging.PagingData
import com.pieterv.common.Resource
import com.pieterv.models.Matchup
import com.pieterv.models.MatchupInfo
import com.pieterv.models.PokemonDetail
import com.pieterv.models.PokemonListEntry
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonPagingData(initialPageSize: Int): Resource<Flow<PagingData<PokemonListEntry>>>

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDetail>

    suspend fun getMatchups(): Resource<List<Matchup>>

    suspend fun getMatchupInfo(matchup: Matchup): Resource<MatchupInfo>

}