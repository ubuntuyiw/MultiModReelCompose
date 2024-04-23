package com.features.detail.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.features.detail.domain.model.TvSeriesDetail
import com.features.detail.domain.usecase.GetDetailUseCase
import com.ibrahimkurt.core.common.util.ErrorMessage
import com.ibrahimkurt.core.common.util.onFailure
import com.ibrahimkurt.core.common.util.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase,
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    private val _snapshot = Channel<DetailSnapshot>()
    val snapshot = _snapshot.receiveAsFlow()

    init {
        saveStateHandle.get<Int>("id")?.let {
            getDetail(it)
        }
    }

    private fun getDetail(id: Int) {
        getDetailUseCase(id).onStart {
            state = state.copy(isLoading = true)
        }.onCompletion {
            state = state.copy(isLoading = false)
        }.onEach { resource ->
            resource.onSuccess {
                state = state.copy(tvSeriesDetail = it)
            }.onFailure {
                _snapshot.send(DetailSnapshot.Error(it))
            }
        }.launchIn(viewModelScope)
    }
}

data class DetailState(
    val isLoading: Boolean = false,
    val tvSeriesDetail: TvSeriesDetail = TvSeriesDetail(),
)

sealed interface DetailSnapshot {
    data class Error(val errorMessage: ErrorMessage) : DetailSnapshot
}