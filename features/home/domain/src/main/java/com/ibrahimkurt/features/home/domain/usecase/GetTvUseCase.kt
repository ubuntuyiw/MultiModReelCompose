package com.ibrahimkurt.features.home.domain.usecase

import com.ibrahimkurt.core.common.util.Resource
import com.ibrahimkurt.features.home.domain.model.TvShowList
import com.ibrahimkurt.features.home.domain.repository.HomeRepository
import javax.inject.Inject

class GetTvUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(): Resource<TvShowList?> {
        return homeRepository.getHome()
    }
}