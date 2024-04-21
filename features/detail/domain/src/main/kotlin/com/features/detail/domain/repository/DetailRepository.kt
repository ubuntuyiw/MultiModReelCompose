package com.features.detail.domain.repository

import com.features.detail.domain.model.TvSeriesDetail
import com.ibrahimkurt.core.common.util.Resource

interface DetailRepository {
    suspend fun getDetail(id: Int): Resource<TvSeriesDetail>
}