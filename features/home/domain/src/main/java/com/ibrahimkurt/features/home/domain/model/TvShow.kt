package com.ibrahimkurt.features.home.domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val originCountry: List<String>,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)