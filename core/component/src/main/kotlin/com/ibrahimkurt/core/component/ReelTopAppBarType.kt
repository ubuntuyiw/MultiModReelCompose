package com.ibrahimkurt.core.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.ibrahimkurt.core.component.ReelTopAppBarType.ReelTopAppBar
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme
import com.ibrahimkurt.core.component.util.Constants.EMPTY_STRING

object ReelTopAppBarType {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun reelColor(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        scrolledContainerColor: Color = MaterialTheme.colorScheme.primary,
        navigationIconContentColor: Color = MaterialTheme.colorScheme.secondary,
        titleContentColor: Color = MaterialTheme.colorScheme.onBackground,
    ): TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        navigationIconContentColor = navigationIconContentColor,
        titleContentColor = titleContentColor,
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ReelTopAppBar(
        modifier: Modifier = Modifier,
        title: @Composable () -> Unit = {},
        navigationIcon: @Composable () -> Unit = {},
        actions: @Composable RowScope.() -> Unit = {},
        colors: TopAppBarColors = reelColor(),
        scrollBehavior: TopAppBarScrollBehavior? = null
    ) {
        val localDensity = LocalDensity.current
        val left = TopAppBarDefaults.windowInsets.getLeft(localDensity, LayoutDirection.Ltr)
        val right = TopAppBarDefaults.windowInsets.getLeft(localDensity, LayoutDirection.Rtl)
        val top = TopAppBarDefaults.windowInsets.getTop(localDensity)
        val padding = WindowInsets(
            left = left,
            right = right,
            top = top,
            bottom = 0
        )
        TopAppBar(
            title = title,
            modifier = modifier,
            windowInsets = padding,
            navigationIcon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    navigationIcon()
                }
            },
            actions = actions,
            colors = colors,
            scrollBehavior = scrollBehavior
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@ReelPreview
@Composable
private fun ReelTopAppBarPreview() {
    MultiModReelComposeTheme {
        ReelTopAppBar(
            title = {
                Text(text = "MultiModReelCompose")
            },
            navigationIcon = {
                ReelIconButtonType.ReelIconButton(
                    onClick = {},
                    colors = ReelIconButtonType.reelIconButtonColor()
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = EMPTY_STRING,
                    )
                }
            }
        )
    }
}