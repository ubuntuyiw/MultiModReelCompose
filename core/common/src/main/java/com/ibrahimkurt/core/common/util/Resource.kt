package com.ibrahimkurt.core.common.util

import android.content.res.Resources
import androidx.annotation.StringRes
import com.ibrahimkurt.core.common.R
import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING

sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>
    data class Error<T>(
        private val message: String = EMPTY_STRING,
        @StringRes
        private val stringRes: Int = R.string.error_unknown,
    ) : Resource<T> {
        fun getErrorMessage(resources: Resources): String {
            return this.message.ifBlank {
                resources.getString(this.stringRes)
            }
        }
    }
}
