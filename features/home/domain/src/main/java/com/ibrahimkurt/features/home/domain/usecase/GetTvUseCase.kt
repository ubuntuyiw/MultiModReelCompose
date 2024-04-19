package com.ibrahimkurt.features.home.domain.usecase

import androidx.paging.PagingData
import com.ibrahimkurt.features.home.domain.model.TvShow
import com.ibrahimkurt.features.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTvUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun execute(): Flow<PagingData<TvShow>> {
        return homeRepository.getHome()
    }
}