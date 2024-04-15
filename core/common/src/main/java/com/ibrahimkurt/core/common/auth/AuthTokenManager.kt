package com.ibrahimkurt.core.common.auth

interface AuthTokenManager {

    var accessToken: String

    fun isTokenAvailable(): Boolean
}