package com.ibrahimkurt.features.home.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ibrahimkurt.core.ui.extensions.navigateTopSingle

data class HomeNavActions(
    val navigateToDetail: () -> Unit
)

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigateTopSingle("home", navOptions)
}

fun NavGraphBuilder.home(homeNavActions: HomeNavActions) {
    composable(route = "home") {
        HomeRoute(homeNavActions)
    }
}