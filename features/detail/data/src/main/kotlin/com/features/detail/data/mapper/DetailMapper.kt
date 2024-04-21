package com.features.detail.data.mapper

import com.features.detail.data.dto.TvSeriesDetailsResponse
import com.features.detail.domain.model.TvSeriesDetail
import com.ibrahimkurt.core.common.util.orZero

fun TvSeriesDetailsResponse.toDomain() = TvSeriesDetail(
    backdropPath = backdropPath.orEmpty(),
    id = id.orZero(),
    name = name.orEmpty(),
    numberOfEpisodes = numberOfEpisodes.orZero(),
    numberOfSeasons = numberOfSeasons.orZero(),
    originalLanguage = originalLanguage.orEmpty(),
    originalName = originalName.orEmpty(),
    overview = overview.orEmpty(),
    popularity = popularity.orZero(),
    posterPath = posterPath.orEmpty(),
    status = status.orEmpty(),
    voteAverage = voteAverage.orZero(),
)