package com.ibrahimkurt.features.home.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.home() {
    composable(route = "home") {
        HomeRoute()
    }
}