package com.ibrahimkurt.core.network.di

import android.app.Application
import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.util.DebugLogger
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ibrahimkurt.core.network.BuildConfig
import com.ibrahimkurt.core.network.calladapter.NetworkResultCallAdapterFactory
import com.ibrahimkurt.core.network.intercapter.AuthTokenInterceptor
import com.ibrahimkurt.core.network.intercapter.NetworkInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
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
    fun provideNetworkInterceptor(@ApplicationContext context: Context): NetworkInterceptor =
        NetworkInterceptor(context)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        chuckInterceptor: ChuckerInterceptor,
        authTokenInterceptor: AuthTokenInterceptor,
        networkInterceptor: NetworkInterceptor,
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

    @Provides
    @Singleton
    fun okHttpCallFactory(
        chuckInterceptor: ChuckerInterceptor
    ): Call.Factory {
        return OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) addInterceptor(chuckInterceptor)
            }
            .build()
    }

    @Provides
    @Singleton
    fun imageLoader(
        okHttpCallFactory: Call.Factory,
        @ApplicationContext application: Context,
    ): ImageLoader {
        return ImageLoader.Builder(application)
            .callFactory(okHttpCallFactory)
            .components { add(SvgDecoder.Factory()) }
            .respectCacheHeaders(false)
            .apply {
                if (BuildConfig.DEBUG) {
                    logger(DebugLogger())
                }
            }
            .build()
    }
}