package com.pieterv.domain.impl

import com.pieterv.common.Resource
import com.pieterv.data.repository.PokemonRepository
import com.pieterv.models.Matchup
import com.pieterv.models.MatchupInfo
import javax.inject.Inject

class GetInfoOnTypeMatchupUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(matchup: Matchup): Resource<MatchupInfo> {
        return pokemonRepository.getMatchupInfo(matchup)
    }
}