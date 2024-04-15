package com.ibrahimkurt.multimodreelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ibrahimkurt.multimodreelcompose.ui.theme.MultiModReelComposeTheme
import com.ibrahimkurt.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiModReelComposeTheme {
                AppNavHost()
            }
        }
    }
}