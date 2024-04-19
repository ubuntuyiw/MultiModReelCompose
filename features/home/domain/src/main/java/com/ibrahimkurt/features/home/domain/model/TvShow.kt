package com.ibrahimkurt.features.home.domain.model

data class TvShow(
    val id: Int = 0,
    val name: String = "",
    val originalLanguage: String = "",
    val originalName: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val backdropPath: String = "",
    val firstAirDate: String = "",
    val genreIds: List<Int> = emptyList(),
    val originCountry: List<String> = emptyList(),
    val posterPath: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)