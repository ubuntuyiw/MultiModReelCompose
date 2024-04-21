package com.ibrahimkurt.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.features.ui.detail.detail
import com.features.ui.detail.navigateToDetail
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme
import com.ibrahimkurt.features.home.ui.HomeNavActions
import com.ibrahimkurt.features.home.ui.home

@Composable
fun AppNavHost() {
    val appNavHostController = rememberNavController()
    MultiModReelComposeTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            NavHost(navController = appNavHostController, startDestination = "home") {
                home(
                    homeNavActions = HomeNavActions(
                        navigateToDetail = appNavHostController::navigateToDetail
                    )
                )

                detail()
            }
        }
    }
}