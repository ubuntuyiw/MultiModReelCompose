package com.features.detail.domain.usecase

import com.features.detail.domain.repository.DetailRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    operator fun invoke(id: Int) = flow {
        emit(detailRepository.getDetail(id))
    }
}