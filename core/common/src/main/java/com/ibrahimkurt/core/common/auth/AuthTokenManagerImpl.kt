package com.ibrahimkurt.core.common.auth

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING
import javax.inject.Inject
import kotlin.concurrent.Volatile

class AuthTokenManagerImpl @Inject constructor() : AuthTokenManager {

    @Volatile
    override var accessToken: String = EMPTY_STRING

    override fun isTokenAvailable(): Boolean = accessToken.isNotBlank()
}