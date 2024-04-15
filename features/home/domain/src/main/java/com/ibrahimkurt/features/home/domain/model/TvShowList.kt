package com.ibrahimkurt.features.home.domain.model

data class TvShowList(
    val page: Int,
    val results: List<TvShow>,
    val totalPages: Int,
    val totalResults: Int
)