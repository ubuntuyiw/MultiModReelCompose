package com.ibrahimkurt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    val appNavHostController = rememberNavController()
    val bottomNavHostController = rememberNavController()
    NavHost(navController = appNavHostController, startDestination = "bottomNavHost") {
        bottomNavHost(bottomNavHostController)
    }
}