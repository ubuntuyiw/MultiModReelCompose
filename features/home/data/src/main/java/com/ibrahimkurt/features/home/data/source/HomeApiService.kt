package com.ibrahimkurt.features.home.data.source

import com.ibrahimkurt.core.network.calladapter.NetworkResult
import com.ibrahimkurt.features.home.data.dto.TvShowResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiService {
    @GET("discover/tv")
    suspend fun getTvShows(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_null_first_air_dates") includeNullFirstAirDates: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): NetworkResult<TvShowResponseDto>
}