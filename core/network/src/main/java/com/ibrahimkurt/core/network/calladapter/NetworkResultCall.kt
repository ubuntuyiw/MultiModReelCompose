package com.ibrahimkurt.core.network.calladapter

import com.ibrahimkurt.core.common.network.NetworkResult
import com.ibrahimkurt.core.network.util.ErrorCategory
import com.ibrahimkurt.core.network.util.NetworkUnavailableException
import okhttp3.Request
import okio.Timeout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.SocketTimeoutException

class NetworkResultCall<T : Any>(
    private val proxy: Call<T>
) : Call<NetworkResult<T>> {

    override fun enqueue(callback: Callback<NetworkResult<T>>) {
        proxy.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val networkResult = handleApiNetworkResult(response)

                callback.onResponse(this@NetworkResultCall, Response.success(networkResult))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val networkResult: NetworkResult<T> =
                    if (t is NetworkUnavailableException) {
                        NetworkResult.Error(resError = ErrorCategory.NetworkUnavailable.message)
                    } else {
                        NetworkResult.Error(resError = ErrorCategory.UnknownError.message)
                    }
                callback.onResponse(this@NetworkResultCall, Response.success(networkResult))
            }
        })
    }

    private fun <T> handleApiNetworkResult(
        response: Response<T>
    ): NetworkResult<T> {
        return try {
            val body = response.body()

            if (response.isSuccessful) {
                body?.let {
                    NetworkResult.Success(body)
                }
                    ?: NetworkResult.Error(resError = ErrorCategory.NotFound.message)
            } else {
                if (response.code() >= 500) {
                    NetworkResult.Error(resError = ErrorCategory.ServerError.message)
                } else {
                    val errorBody = JSONObject(response.errorBody()?.string() ?: "{}")
                    val message = errorBody.getString("status_message")
                    NetworkResult.Error(error = message)
                }
            }
        } catch (e: SocketTimeoutException) {
            NetworkResult.Error(resError = ErrorCategory.TimeOut.message)
        } catch (e: Throwable) {
            NetworkResult.Error(resError = ErrorCategory.UnknownError.message)
        }
    }

    override fun execute(): Response<NetworkResult<T>> = throw NotImplementedError()
    override fun clone(): Call<NetworkResult<T>> = NetworkResultCall(proxy.clone())
    override fun request(): Request = proxy.request()
    override fun timeout(): Timeout = proxy.timeout()
    override fun isExecuted(): Boolean = proxy.isExecuted
    override fun isCanceled(): Boolean = proxy.isCanceled
    override fun cancel() {
        proxy.cancel()
    }
}
