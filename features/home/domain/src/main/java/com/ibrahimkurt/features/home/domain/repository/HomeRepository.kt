package com.ibrahimkurt.features.home.domain.repository

import androidx.paging.PagingData
import com.ibrahimkurt.features.home.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getHome(): Flow<PagingData<TvShow>>
}