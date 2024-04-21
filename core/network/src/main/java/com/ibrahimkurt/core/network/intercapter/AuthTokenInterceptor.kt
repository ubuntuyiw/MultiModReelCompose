package com.ibrahimkurt.core.network.intercapter

import com.ibrahimkurt.core.common.util.TokenManager.token
import com.ibrahimkurt.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        token = BuildConfig.API_KEY
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .header("Authorization", "Bearer ${BuildConfig.API_KEY}")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}