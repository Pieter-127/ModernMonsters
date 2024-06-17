package com.pieterv.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pieterv.common.Resource
import com.pieterv.domain.impl.GetPokemonDetailsUseCase
import com.pieterv.models.PokemonName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonDetailScreenViewModel @Inject constructor(
    val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(PokemonDetailState())
    var state = _state.asStateFlow()

    fun loadPokemon(pokemonName: PokemonName) {
        _state.update {currentState ->
            currentState.copy(
                failedLoading = false,
                isLoading = true,
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            val response = getPokemonDetailsUseCase(pokemonName)
            if (response is Resource.Success) {
                response.data.let { detail ->
                    if (detail != null) {
                        _state.update { currentState ->
                            currentState.copy(
                                failedLoading = false,
                                isLoading = false,
                                data = detail
                            )
                        }
                    } else {
                        _state.update { currentState ->
                            currentState.copy(
                                failedLoading = false,
                                isLoading = false,
                            )
                        }
                    }
                }
            } else {
                _state.update {
                    it.copy(failedLoading = true, isLoading = false)
                }
            }
        }
    }
}