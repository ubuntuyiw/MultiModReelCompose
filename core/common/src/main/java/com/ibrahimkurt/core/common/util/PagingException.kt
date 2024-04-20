package com.ibrahimkurt.core.common.util


class PagingException(
    val error: String = Constants.EMPTY_STRING,
    val resError: Int = 0
) : Exception()