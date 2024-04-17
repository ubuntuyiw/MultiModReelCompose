package com.ibrahimkurt.features.home.data.repository

import com.ibrahimkurt.core.common.util.Resource
import com.ibrahimkurt.core.network.calladapter.NetworkResult
import com.ibrahimkurt.features.home.data.mapper.toDomain
import com.ibrahimkurt.features.home.data.source.HomeApiService
import com.ibrahimkurt.features.home.domain.model.TvShowList
import com.ibrahimkurt.features.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeRepository {

    override suspend fun getHome(): Resource<TvShowList?> {
        return when(val result = homeApiService.getTvShows()) {
            is NetworkResult.Success -> Resource.Success(result.data.toDomain())
            is NetworkResult.Error -> Resource.Error(result.error, result.resError)
        }
    }
}