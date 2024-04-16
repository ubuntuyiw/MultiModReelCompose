package com.ibrahimkurt.core.common.network

import androidx.annotation.StringRes
import com.ibrahimkurt.core.common.R
import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>

    data class Error<T>(
        val error: String = EMPTY_STRING,
        @StringRes
        val resError: Int = R.string.error_unknown
    ) : NetworkResult<T>
}