package com.ibrahimkurt.features.home.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

data class HomeNavActions(
    val navigateToDetail: () -> Unit
)

fun NavGraphBuilder.home(homeNavActions: HomeNavActions) {
    composable(route = "home") {
        HomeRoute(homeNavActions)
    }
}