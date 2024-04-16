package com.ibrahimkurt.core.network.intercapter

import android.content.Context
import com.ibrahimkurt.core.network.util.NetworkUnavailableException
import com.ibrahimkurt.core.network.extensions.isNetworkAvailable
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (context.isNetworkAvailable()) {
            val builder = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
            return chain.proceed(builder.build())
        } else {
            throw NetworkUnavailableException()
        }
    }
}