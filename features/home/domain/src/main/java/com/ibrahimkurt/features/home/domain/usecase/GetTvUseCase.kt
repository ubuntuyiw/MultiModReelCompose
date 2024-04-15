package com.ibrahimkurt.features.home.domain.usecase

import com.ibrahimkurt.features.home.domain.model.TvShowList
import com.ibrahimkurt.features.home.domain.repository.HomeRepository
import javax.inject.Inject

class GetTvUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(): TvShowList? {
        return homeRepository.getHome()
    }
}