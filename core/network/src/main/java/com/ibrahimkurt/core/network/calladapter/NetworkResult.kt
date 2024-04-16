package com.ibrahimkurt.core.network.calladapter

import androidx.annotation.StringRes
import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING
import com.ibrahimkurt.core.network.R

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>

    data class Error<T>(
        val error: String = EMPTY_STRING,
        @StringRes
        val resError: Int = R.string.error_unknown
    ) : NetworkResult<T>
}