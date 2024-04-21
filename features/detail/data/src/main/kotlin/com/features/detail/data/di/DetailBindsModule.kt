package com.features.detail.data.di

import com.features.detail.data.repository.DetailRepositoryImpl
import com.features.detail.domain.repository.DetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DetailBindsModule {

    @Binds
    @ViewModelScoped
    abstract fun bindHomeRepository(impl: DetailRepositoryImpl): DetailRepository
}