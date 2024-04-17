package com.ibrahimkurt.features.home.domain.repository

import com.ibrahimkurt.core.common.util.Resource
import com.ibrahimkurt.features.home.domain.model.TvShowList

interface HomeRepository {
    suspend fun getHome(): Resource<TvShowList?>
}