package com.ibrahimkurt.core.common.auth

import com.ibrahimkurt.core.common.util.Constants.EMPTY_STRING
import javax.inject.Inject
import kotlin.concurrent.Volatile

class AuthTokenManagerImpl @Inject constructor() : AuthTokenManager {

    @Volatile
    override var accessToken: String = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjZmE1YjZmZDY2ZmJiOWIxMmJkMjU5ZGFjNmVkNTc0YSIsInN1YiI6IjY0MGE0Mjk2Mjc5MGJmMDA3YjQ4YzU2YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XhZzzm3jsoln2WJgNbrIWu8Z0NSo_uSgqGbEJFmqXzI"


    override fun isTokenAvailable(): Boolean = accessToken.isNotBlank()

}