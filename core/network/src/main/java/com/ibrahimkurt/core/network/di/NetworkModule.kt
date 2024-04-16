package com.ibrahimkurt.core.network.di

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ibrahimkurt.core.network.BuildConfig
import com.ibrahimkurt.core.network.calladapter.NetworkResultCallAdapterFactory
import com.ibrahimkurt.core.network.intercapter.AuthTokenInterceptor
import com.ibrahimkurt.core.network.intercapter.NetworkInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            useAlternativeNames = true
            isLenient = true
            allowSpecialFloatingPointValues = false
            allowStructuredMapKeys = false
            coerceInputValues = true
        }
    }

    @Provides
    @Singleton
    fun provideChuckInterceptor(application: Application): ChuckerInterceptor =
        ChuckerInterceptor.Builder(application).build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        chuckInterceptor: ChuckerInterceptor,
        authTokenInterceptor: AuthTokenInterceptor,
        networkInterceptor: NetworkInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(chuckInterceptor)
            addInterceptor(networkInterceptor)
            addInterceptor(authTokenInterceptor)
            readTimeout(60L, TimeUnit.SECONDS)
            connectTimeout(60L, TimeUnit.SECONDS)
            writeTimeout(60L, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}