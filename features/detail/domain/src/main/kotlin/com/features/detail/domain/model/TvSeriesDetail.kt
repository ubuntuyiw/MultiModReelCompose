package com.features.detail.domain.model

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING
import com.ibrahimkurt.core.common.util.Constants.ZERO_DOUBLE
import com.ibrahimkurt.core.common.util.Constants.ZERO_FLOAT
import com.ibrahimkurt.core.common.util.Constants.ZERO_INT

data class TvSeriesDetail(
    val backdropPath: String = EMPTY_STRING,
    val id: Int = ZERO_INT,
    val name: String = EMPTY_STRING,
    val numberOfEpisodes: Int = ZERO_INT,
    val numberOfSeasons: Int = ZERO_INT,
    val originalLanguage: String = EMPTY_STRING,
    val originalName: String = EMPTY_STRING,
    val firstAirDate: String = EMPTY_STRING,
    val overview: String = EMPTY_STRING,
    val popularity: Double = ZERO_DOUBLE,
    val posterPath: String = EMPTY_STRING,
    val status: String = EMPTY_STRING,
    val voteAverage: Float = ZERO_FLOAT,
    val voteAverageFormat: String = EMPTY_STRING
)