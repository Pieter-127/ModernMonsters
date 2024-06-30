package com.pieterv.typeinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pieterv.common.Resource
import com.pieterv.domain.impl.GetInfoOnTypeMatchupUseCase
import com.pieterv.models.Matchup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TypeInfoViewModel @Inject constructor(
    val getInfoOnTypeMatchup: GetInfoOnTypeMatchupUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(TypeInfoState())
    var state = _state.asStateFlow()

    fun loadInfoForMatchup(matchup: Matchup) {
        _state.update { currentState ->
            currentState.copy(
                failedLoading = false,
                isLoading = true,
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            val response = getInfoOnTypeMatchup(matchup)
            withContext(Dispatchers.Main) {
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
}