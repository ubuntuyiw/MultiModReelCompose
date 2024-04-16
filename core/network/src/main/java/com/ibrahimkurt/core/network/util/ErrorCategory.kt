package com.ibrahimkurt.core.network.util

import androidx.annotation.StringRes
import com.ibrahimkurt.core.network.R

enum class ErrorCategory(@StringRes val message: Int) {
    UnknownError(R.string.error_unknown),
    ServerError(R.string.error_system),
    NetworkUnavailable(R.string.error_check_internet),
    NotFound(R.string.error_not_found),
    TimeOut(R.string.error_response_not_received),
}