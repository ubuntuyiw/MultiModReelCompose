package com.features.detail.data.repository

import com.features.detail.data.mapper.toDomain
import com.features.detail.data.source.DetailApiService
import com.features.detail.domain.model.TvSeriesDetail
import com.features.detail.domain.repository.DetailRepository
import com.ibrahimkurt.core.common.util.Resource
import com.ibrahimkurt.core.common.util.map
import com.ibrahimkurt.core.network.calladapter.toResource
import javax.inject.Inject

internal class DetailRepositoryImpl @Inject constructor(
    private val detailDataSource: DetailApiService
) : DetailRepository {

    override suspend fun getDetail(id: Int): Resource<TvSeriesDetail> {
        return detailDataSource.getDetailTvSeries(id).toResource().map {
            it.toDomain()
        }
    }
}