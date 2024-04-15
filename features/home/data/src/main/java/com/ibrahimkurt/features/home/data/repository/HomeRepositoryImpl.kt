package com.ibrahimkurt.features.home.data.repository

import com.ibrahimkurt.features.home.data.mapper.toDomain
import com.ibrahimkurt.features.home.data.source.HomeApiService
import com.ibrahimkurt.features.home.domain.model.TvShowList
import com.ibrahimkurt.features.home.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeRepository {

    override suspend fun getHome(): TvShowList? {
        return withContext(Dispatchers.IO) {
            homeApiService.getTvShows().body()?.toDomain()
        }
    }
}