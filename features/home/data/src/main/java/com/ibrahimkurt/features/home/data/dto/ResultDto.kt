package com.ibrahimkurt.features.home.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResultDto(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val first_air_date: String? = null,
    val genre_ids: List<Int>? = null,
    val id: Int? = null,
    val name: String? = null,
    val origin_country: List<String>? = null,
    val original_language: String? = null,
    val original_name: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,
)