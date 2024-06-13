package com.pieterv.domain.impl

import com.pieterv.common.Resource
import com.pieterv.data.repository.PokemonRepository
import com.pieterv.models.PokemonDetail
import com.pieterv.models.PokemonName
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(pokemonName: PokemonName): Resource<PokemonDetail> {
        return pokemonRepository.getPokemonInfo(pokemonName)
    }
}