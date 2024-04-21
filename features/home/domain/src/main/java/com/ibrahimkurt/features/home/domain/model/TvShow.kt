package com.ibrahimkurt.features.home.domain.model

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING
import com.ibrahimkurt.core.common.util.Constants.ZERO_DOUBLE
import com.ibrahimkurt.core.common.util.Constants.ZERO_FLOAT
import com.ibrahimkurt.core.common.util.Constants.ZERO_INT

data class TvShow(
    val id: Int = ZERO_INT,
    val name: String = EMPTY_STRING,
    val originalLanguage: String = EMPTY_STRING,
    val originalName: String = EMPTY_STRING,
    val overview: String = EMPTY_STRING,
    val popularity: Double = ZERO_DOUBLE,
    val backdropPath: String = EMPTY_STRING,
    val firstAirDate: String = EMPTY_STRING,
    val genreIds: List<Int> = emptyList(),
    val originCountry: List<String> = emptyList(),
    val posterPath: String = EMPTY_STRING,
    val voteAverage: Float = ZERO_FLOAT,
    val voteAverageFormat: String = EMPTY_STRING,
    val voteCount: Int = ZERO_INT
)