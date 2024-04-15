package com.ibrahimkurt.core.common.di

import com.ibrahimkurt.core.common.auth.AuthTokenManager
import com.ibrahimkurt.core.common.auth.AuthTokenManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {

    @Singleton
    @Binds
    abstract fun bindAuthTokenManager(authTokenManager: AuthTokenManagerImpl): AuthTokenManager
}