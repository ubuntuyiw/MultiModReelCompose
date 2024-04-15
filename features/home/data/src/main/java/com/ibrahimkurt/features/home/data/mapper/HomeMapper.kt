package com.ibrahimkurt.features.home.data.mapper

import com.ibrahimkurt.features.home.data.dto.ResultDto
import com.ibrahimkurt.features.home.data.dto.TvShowResponseDto
import com.ibrahimkurt.features.home.domain.model.TvShow
import com.ibrahimkurt.features.home.domain.model.TvShowList

fun TvShowResponseDto.toDomain(): TvShowList {
    return TvShowList(
        page = page ?: 0,
        results = results?.map { it.toDomain() } ?: emptyList(),
        totalPages = totalPages ?: 0,
        totalResults = totalResults ?: 0
    )
}

fun ResultDto.toDomain(): TvShow {
    return TvShow(
        id = id ?: 0,
        name = name ?: "",
        originalLanguage = originalLanguage ?: "",
        originalName = originalName ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        backdropPath = backdropPath ?: "",
        firstAirDate = firstAirDate ?: "",
        genreIds = genreIds ?: emptyList(),
        originCountry = originCountry ?: emptyList(),
        posterPath = posterPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0
    )
}