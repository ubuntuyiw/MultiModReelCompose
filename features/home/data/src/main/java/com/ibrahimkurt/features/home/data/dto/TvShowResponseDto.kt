package com.ibrahimkurt.features.home.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TvShowResponseDto(
    val page: Int? = null,
    val results: List<ResultDto>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null,
)