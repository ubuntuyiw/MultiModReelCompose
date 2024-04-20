package com.ibrahimkurt.core.common.util

import android.content.res.Resources
import androidx.annotation.StringRes
import com.ibrahimkurt.core.common.R
import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING

sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T> {
        suspend fun<T : Any, N : Any> Resource<T>.getDataOrNull(dataCallBack: suspend (T) -> N?): N? {
            return when (this) {
                is Success -> dataCallBack(this.data)
                is Error -> null
            }
        }
    }

    data class Error<T>(
        internal val message: String = EMPTY_STRING,
        @StringRes
        internal val stringRes: Int = R.string.error_unknown,
    ) : Resource<T> {
        fun getErrorMessage(resources: Resources): String {
            return this.message.ifBlank {
                resources.getString(this.stringRes)
            }
        }

        fun toPagingException(): PagingException {
            return PagingException(this.message, this.stringRes)
        }
    }
}

suspend fun <T : Any, N : Any> Resource<T>.map(data: suspend (T) -> N): Resource<N> {
    return when (this) {
        is Resource.Success -> Resource.Success(data(this.data))
        is Resource.Error -> Resource.Error(this.message, this.stringRes)
    }
}