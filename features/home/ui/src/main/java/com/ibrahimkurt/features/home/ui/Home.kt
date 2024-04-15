package com.ibrahimkurt.features.home.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimkurt.features.home.domain.usecase.GetTvUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun HomeRoute() {
    val viewModel: HomeViewModel = hiltViewModel()
    Log.d("asdasd",viewModel.getHome().toString())
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Merhaba")
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val getTvUseCase: GetTvUseCase
): ViewModel() {

    fun getHome() {
        viewModelScope.launch {
            val result = getTvUseCase.execute()
            Log.d("HomeViewModel", "getHome: $result")

        }
    }
}