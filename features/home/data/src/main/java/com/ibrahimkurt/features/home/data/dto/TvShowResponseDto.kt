package com.ibrahimkurt.features.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvShowResponseDto(
    val page: Int? = null,
    val results: List<ResultDto>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null,
)