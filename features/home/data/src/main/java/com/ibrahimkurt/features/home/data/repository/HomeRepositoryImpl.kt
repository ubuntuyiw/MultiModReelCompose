package com.ibrahimkurt.features.home.data.repository

import androidx.paging.PagingData
import com.ibrahimkurt.core.common.util.map
import com.ibrahimkurt.core.network.calladapter.toResource
import com.ibrahimkurt.features.home.data.mapper.toDomain
import com.ibrahimkurt.features.home.data.source.HomeApiService
import com.ibrahimkurt.features.home.domain.model.TvShow
import com.ibrahimkurt.features.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import pagination.safeApiCallPaging
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeRepository {

    override fun getHome(): Flow<PagingData<TvShow>> {
        return safeApiCallPaging { page, _ ->
            homeApiService.getTvShows(page = page).toResource().map {
                it.results.toDomain()
            }
        }
    }
}