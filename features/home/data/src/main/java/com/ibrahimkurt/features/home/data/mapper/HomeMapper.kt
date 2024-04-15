package com.ibrahimkurt.features.home.data.mapper

import com.ibrahimkurt.features.home.domain.model.TvShow
import com.ibrahimkurt.features.home.domain.model.TvShowList
import com.ibrahimkurt.features.home.data.dto.ResultDto
import com.ibrahimkurt.features.home.data.dto.TvShowResponseDto

fun TvShowResponseDto.toDomain(): TvShowList {
    return TvShowList(
        page = page ?: 0,
        results = results?.map { it.toDomain() } ?: emptyList(),
        totalPages = total_pages ?: 0,
        totalResults = total_results ?: 0
    )
}

fun ResultDto.toDomain(): TvShow {
    return TvShow(
        id = id ?: 0,
        name = name ?: "",
        originalLanguage = original_language ?: "",
        originalName = original_name ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        backdropPath = backdrop_path ?: "",
        firstAirDate = first_air_date ?: "",
        genreIds = genre_ids ?: emptyList(),
        originCountry = origin_country ?: emptyList(),
        posterPath = poster_path ?: "",
        voteAverage = vote_average ?: 0.0,
        voteCount = vote_count ?: 0
    )
}