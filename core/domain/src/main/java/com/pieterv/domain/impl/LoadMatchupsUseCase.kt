package com.pieterv.domain.impl

import com.pieterv.common.Resource
import com.pieterv.data.repository.PokemonRepository
import com.pieterv.models.Matchup
import javax.inject.Inject

class LoadMatchupsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): Resource<List<Matchup>> {
        return pokemonRepository.getMatchups()
    }
}