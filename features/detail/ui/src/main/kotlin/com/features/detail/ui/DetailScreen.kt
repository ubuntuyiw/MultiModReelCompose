package com.features.detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.features.detail.domain.model.TvSeriesDetail
import com.ibrahimkurt.core.component.ReelIconButtonType
import com.ibrahimkurt.core.component.ReelPreview
import com.ibrahimkurt.core.component.ReelScaffoldType
import com.ibrahimkurt.core.component.ReelTopAppBarType
import com.ibrahimkurt.core.component.util.Constants

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel(),
    detailNavActions: DetailNavActions
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.snapshot.collect {
            when (it) {
                is DetailSnapshot.Error -> {
                }
            }
        }
    }

    DetailScreen(
        detailNavActions,
        viewModel.state
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    detailNavActions: DetailNavActions,
    state: DetailState
) {
    ReelScaffoldType.PrimaryScaffold(
        topBar = {
            ReelTopAppBarType.ReelTopAppBar(
                navigationIcon = {
                    Box(modifier = Modifier) {
                        ReelIconButtonType.ReelIconButton(
                            onClick = { detailNavActions.navigateToBack() },
                            colors = ReelIconButtonType.reelIconButtonColor()
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = Constants.EMPTY_STRING,
                            )
                        }



                    }

                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Text(
                text = state.tvSeriesDetail.name,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@ReelPreview
@Composable
fun DetailPreview() {
    DetailScreen(
        detailNavActions = DetailNavActions(
            navigateToBack = {}
        ),
        state = DetailState(
            tvSeriesDetail = TvSeriesDetail(name = "Example")
        )
    )
}