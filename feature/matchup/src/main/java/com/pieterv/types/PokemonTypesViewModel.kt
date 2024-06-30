package com.pieterv.types

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pieterv.common.Resource
import com.pieterv.domain.impl.LoadMatchupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonTypesViewModel @Inject constructor(
    val loadMatchupsUseCase: LoadMatchupsUseCase,
) : ViewModel() {

    private var _state = MutableStateFlow(MatchupsState())
    var state = _state.asStateFlow()

    fun loadMatchups() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = loadMatchupsUseCase()
            withContext(Dispatchers.Main) {
                if (response is Resource.Success) {
                    _state.update {
                        it.copy(
                            matchups = response.data ?: emptyList(),
                            failedLoading = false,
                            isLoading = false
                        )
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