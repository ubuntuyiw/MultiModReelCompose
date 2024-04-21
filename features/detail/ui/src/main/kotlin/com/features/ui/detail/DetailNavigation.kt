package com.features.ui.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ibrahimkurt.core.ui.extensions.navigateTopSingle

fun NavController.navigateToDetail(navOptions: NavOptions? = null) {
    navigateTopSingle("detail", navOptions)
}

fun NavGraphBuilder.detail() {
    composable(route = "detail") {
        DetailRoute()
    }
}