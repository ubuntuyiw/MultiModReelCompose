package com.ibrahimkurt.core.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme

object SAScaffoldType {

    @Composable
    private fun SAScaffold(
        modifier: Modifier = Modifier,
        topBar: @Composable () -> Unit = {},
        bottomBar: @Composable () -> Unit = {},
        snackbarHost: @Composable () -> Unit = {},
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        floatingActionButton: @Composable () -> Unit = {},
        floatingActionButtonPosition: FabPosition = FabPosition.End,
        contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
        content: @Composable (PaddingValues) -> Unit
    ) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = snackbarHost,
            floatingActionButton = floatingActionButton,
            floatingActionButtonPosition = floatingActionButtonPosition,
            containerColor = containerColor,
            contentColor = contentColor,
            contentWindowInsets = contentWindowInsets,
            content = {
                content(it)
            },
        )
    }

    @Composable
    fun SAPrimaryScaffold(
        modifier: Modifier = Modifier,
        topBar: @Composable () -> Unit = {},
        bottomBar: @Composable () -> Unit = {},
        snackbarHost: @Composable () -> Unit = {},
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        floatingActionButton: @Composable () -> Unit = {},
        floatingActionButtonPosition: FabPosition = FabPosition.End,
        contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
        content: @Composable (PaddingValues) -> Unit
    ) {
        SAScaffold(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
            topBar = topBar,
            bottomBar = bottomBar,
            contentColor = contentColor,
            containerColor = containerColor,
            snackbarHost = snackbarHost,
            floatingActionButton = floatingActionButton,
            floatingActionButtonPosition = floatingActionButtonPosition,
            contentWindowInsets = contentWindowInsets,
            content = {
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        contentAlignment = Alignment.TopCenter,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        content(it)
                    }
                }
            },
        )
    }
}

@ReelPreview
@Composable
fun SAPrimaryScaffoldPreview() {
    MultiModReelComposeTheme {
        SAScaffoldType.SAPrimaryScaffold {}
    }
}