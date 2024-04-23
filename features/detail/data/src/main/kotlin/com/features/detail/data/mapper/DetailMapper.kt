package com.features.detail.data.mapper

import com.features.detail.data.dto.TvSeriesDetailsResponse
import com.features.detail.domain.model.TvSeriesDetail
import com.ibrahimkurt.core.common.util.APIConst.IMAGE_URL
import com.ibrahimkurt.core.common.util.APIConst.ORIGINAL_IMAGE_URL
import com.ibrahimkurt.core.common.util.orZero
import java.util.Locale

fun TvSeriesDetailsResponse.toDomain() = TvSeriesDetail(
    backdropPath = ORIGINAL_IMAGE_URL + backdropPath.orEmpty(),
    id = id.orZero(),
    name = name.orEmpty(),
    numberOfEpisodes = numberOfEpisodes.orZero(),
    numberOfSeasons = numberOfSeasons.orZero(),
    originalLanguage = originalLanguage.orEmpty(),
    firstAirDate = firstAirDate.orEmpty(),
    originalName = originalName.orEmpty(),
    overview = overview.orEmpty(),
    popularity = popularity.orZero(),
    posterPath = IMAGE_URL + posterPath.orEmpty(),
    status = status.orEmpty(),
    voteAverage = voteAverage?.toFloat().orZero(),
    voteAverageFormat = String.format(Locale.US, "%.1f", voteAverage.orZero()),
)