package com.features.ui.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel()
) {
    DetailScreen()
}

@Composable
fun DetailScreen() {
}

@Composable
fun DetailPreview() {
    DetailScreen()
}