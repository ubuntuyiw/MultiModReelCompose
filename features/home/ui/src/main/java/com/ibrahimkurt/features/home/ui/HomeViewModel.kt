package com.ibrahimkurt.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ibrahimkurt.features.home.domain.model.TvShow
import com.ibrahimkurt.features.home.domain.usecase.GetTvUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTvUseCase: GetTvUseCase
) : ViewModel() {
    private val _homePaging = MutableStateFlow(PagingData.empty<TvShow>())
    val homePaging: StateFlow<PagingData<TvShow>> = _homePaging

    init {
        getHome()
    }

    private fun getHome() {
        getTvUseCase.execute().cachedIn(viewModelScope).onEach { pagingData ->
            _homePaging.update { pagingData }
        }.launchIn(viewModelScope)
    }
}