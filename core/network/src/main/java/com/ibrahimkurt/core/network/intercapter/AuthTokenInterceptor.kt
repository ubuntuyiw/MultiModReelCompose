package com.ibrahimkurt.core.network.intercapter

import com.ibrahimkurt.core.common.auth.AuthTokenManager
import com.ibrahimkurt.core.network.BuildConfig
import io.ktor.http.HttpHeaders
import io.ktor.http.auth.AuthScheme
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor(
    private val authTokenManager: AuthTokenManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        authTokenManager.accessToken = BuildConfig.API_KEY
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .header(HttpHeaders.Authorization, "${AuthScheme.Bearer} ${BuildConfig.API_KEY}")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}