package com.ibrahimkurt.features.home.data.mapper

import com.ibrahimkurt.core.common.util.orZero
import com.ibrahimkurt.features.home.data.dto.ResultDto
import com.ibrahimkurt.features.home.domain.model.TvShow
import java.util.Locale

fun List<ResultDto>?.toDomain() = this?.map {
    TvShow(
        id = it.id.orZero(),
        name = it.name.orEmpty(),
        originalLanguage = it.originalLanguage.orEmpty(),
        originalName = it.originalName.orEmpty(),
        overview = it.overview.orEmpty(),
        popularity = it.popularity.orZero(),
        backdropPath = it.backdropPath.orEmpty(),
        firstAirDate = it.firstAirDate.orEmpty(),
        genreIds = it.genreIds.orEmpty(),
        originCountry = it.originCountry.orEmpty(),
        posterPath = it.posterPath.orEmpty(),
        voteAverage = it.voteAverage?.toFloat().orZero(),
        voteAverageFormat = String.format(Locale.US, "%.1f", it.voteAverage.orZero()),
        voteCount = it.voteCount.orZero()
    )
}.orEmpty()