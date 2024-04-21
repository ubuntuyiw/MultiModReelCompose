package com.ibrahimkurt.core.common.util

import com.ibrahimkurt.core.common.util.Constants.ZERO_DOUBLE
import com.ibrahimkurt.core.common.util.Constants.ZERO_FLOAT
import com.ibrahimkurt.core.common.util.Constants.ZERO_INT

object Constants {
    const val EMPTY_STRING = ""
    const val ZERO_DOUBLE = 0.0
    const val ZERO_INT = 0
    const val ZERO_FLOAT = 0f
}

fun Int?.orZero() = this ?: ZERO_INT
fun Float?.orZero() = this ?: ZERO_FLOAT
fun Double?.orZero() = this ?: ZERO_DOUBLE
fun Boolean?.orFalse() = this ?: false
fun Boolean?.orTrue() = this ?: true