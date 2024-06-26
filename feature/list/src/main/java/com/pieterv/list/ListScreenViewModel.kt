package com.pieterv.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pieterv.common.Resource
import com.pieterv.domain.impl.LoadPokemonListUseCase
import com.pieterv.models.PokemonListEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    val loadPokemonListUseCase: LoadPokemonListUseCase,
) : ViewModel() {

    private var _state = MutableStateFlow(MainScreenState())
    var state = _state.asStateFlow()

    var pokedexEntries: MutableStateFlow<PagingData<PokemonListEntry>> =
        MutableStateFlow(value = PagingData.empty())
        private set

    fun loadPokemon() {
        _state.update {
            it.copy(failedLoading = false, isLoading = true)
        }
        viewModelScope.launch(Dispatchers.IO) {
            val response = loadPokemonListUseCase(20)
            withContext(Dispatchers.Main){
                if (response is Resource.Success) {
                    _state.update {
                        it.copy(failedLoading = false, isLoading = false)
                    }
                    response.data?.cachedIn(viewModelScope)?.collectLatest { latest ->
                        pokedexEntries.value = latest
                    }
                } else {
                    _state.update {
                        it.copy(failedLoading = true, isLoading = false)
                    }
                }
            }
        }
    }
}