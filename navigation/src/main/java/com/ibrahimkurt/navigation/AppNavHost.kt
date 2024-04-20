package com.ibrahimkurt.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme

@Composable
fun AppNavHost() {
    val appNavHostController = rememberNavController()
    val bottomNavHostController = rememberNavController()
    MultiModReelComposeTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            NavHost(navController = appNavHostController, startDestination = "bottomNavHost") {
                bottomNavHost(bottomNavHostController)
            }
        }
    }
}