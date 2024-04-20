package com.ibrahimkurt.features.home.data.mapper

import com.ibrahimkurt.features.home.data.dto.ResultDto
import com.ibrahimkurt.features.home.domain.model.TvShow

fun List<ResultDto>?.toDomain() = this?.map {
    TvShow(
        id = it.id ?: 0,
        name = it.name ?: "",
        originalLanguage = it.originalLanguage ?: "",
        originalName = it.originalName ?: "",
        overview = it.overview ?: "",
        popularity = it.popularity ?: 0.0,
        backdropPath = it.backdropPath ?: "",
        firstAirDate = it.firstAirDate ?: "",
        genreIds = it.genreIds ?: emptyList(),
        originCountry = it.originCountry ?: emptyList(),
        posterPath = it.posterPath ?: "",
        voteAverage = it.voteAverage ?: 0.0,
        voteCount = it.voteCount ?: 0
    )
}.orEmpty()