package com.features.detail.data.source

import com.features.detail.data.dto.TvSeriesDetailsResponse
import com.ibrahimkurt.core.network.calladapter.NetworkResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailApiService {
    @GET("tv/{series_id}")
    suspend fun getDetailTvSeries(
        @Path("series_id") seriesId: Int,
        @Query("language") language: String = "en-US",
    ): NetworkResult<TvSeriesDetailsResponse>
}