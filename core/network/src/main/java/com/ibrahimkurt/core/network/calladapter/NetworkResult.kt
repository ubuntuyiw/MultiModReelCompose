package com.ibrahimkurt.core.network.calladapter

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING
import com.ibrahimkurt.core.common.util.ErrorMessage
import com.ibrahimkurt.core.common.util.Resource

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>

    data class Error<T>(
        val error: String = EMPTY_STRING,
        val resError: Int? = null
    ) : NetworkResult<T>
}

fun <T> NetworkResult<T>.toResource(): Resource<T> {
    return when (this) {
        is NetworkResult.Success -> Resource.Success(data)
        is NetworkResult.Error -> Resource.Error(
            ErrorMessage(message = error, resourceId = resError)
        )
    }
}
