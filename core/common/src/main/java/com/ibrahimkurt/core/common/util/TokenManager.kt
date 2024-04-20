package com.ibrahimkurt.core.common.util

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING

object TokenManager {
    @Volatile
    var token: String = EMPTY_STRING
}