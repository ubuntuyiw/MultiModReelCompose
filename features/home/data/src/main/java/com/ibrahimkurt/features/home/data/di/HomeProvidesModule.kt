package com.ibrahimkurt.features.home.data.di

import com.ibrahimkurt.features.home.data.source.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object HomeProvidesModule {

    @ViewModelScoped
    @Provides
    fun provideNetworkService(retrofit: Retrofit): HomeApiService {
        return retrofit.create(HomeApiService::class.java)
    }
}