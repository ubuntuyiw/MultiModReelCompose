package com.ibrahimkurt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ibrahimkurt.features.home.ui.home

internal fun NavGraphBuilder.bottomNavHost(bottomNavHost: NavHostController) {
    composable(route = "bottomNavHost") {
        BottomNavHost(bottomNavHost)
    }
}

@Composable
internal fun BottomNavHost(bottomNavHost: NavHostController) {
    NavHost(navController = bottomNavHost, startDestination = "home") {
        home()
    }
}