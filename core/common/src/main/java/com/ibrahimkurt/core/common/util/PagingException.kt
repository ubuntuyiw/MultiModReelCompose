package com.ibrahimkurt.core.common.util

import androidx.annotation.StringRes
import com.ibrahimkurt.core.common.R

class PagingException(
    val error: String = Constants.EMPTY_STRING,
    @StringRes
    val resError: Int = R.string.error_unknown
) : Exception()