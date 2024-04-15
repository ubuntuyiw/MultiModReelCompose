package com.ibrahimkurt.features.home.domain.repository

import com.ibrahimkurt.features.home.domain.model.TvShowList

interface HomeRepository {
    suspend fun getHome(): TvShowList?
}