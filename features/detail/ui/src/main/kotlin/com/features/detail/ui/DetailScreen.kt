package com.features.detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.imageLoader
import coil.request.ImageRequest
import com.features.detail.domain.model.TvSeriesDetail
import com.ibrahimkurt.core.component.CoilImage
import com.ibrahimkurt.core.component.ReelIconButtonType
import com.ibrahimkurt.core.component.ReelPreview
import com.ibrahimkurt.core.component.ReelTopAppBarType
import com.ibrahimkurt.core.component.util.Constants
import com.ibrahimkurt.core.ui.widgets.FilmCard

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
    val context = LocalContext.current
    val imageLoader = context.imageLoader
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            val request = ImageRequest.Builder(LocalContext.current)
                .data(state.tvSeriesDetail.backdropPath)
                .crossfade(true)
                .build()

            CoilImage(
                model = request,
                contentDescription = null,
                filterQuality = FilterQuality.High,
                imageLoader = imageLoader,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(y = 75.dp)
            ) {
                FilmCard(
                    model = state.tvSeriesDetail.posterPath,
                    title = state.tvSeriesDetail.name,
                    date = state.tvSeriesDetail.firstAirDate,
                    voteAverage = state.tvSeriesDetail.voteAverage,
                    voteAverageFormat = state.tvSeriesDetail.voteAverageFormat
                )
            }

            ReelTopAppBarType.ReelTopAppBar(
                navigationIcon = {
                    ReelIconButtonType.ReelIconButton(
                        onClick = { detailNavActions.navigateToBack() },
                        colors = ReelIconButtonType.reelIconButtonColor()
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = Constants.EMPTY_STRING,
                        )
                    }
                },
                colors = ReelTopAppBarType.reelColor(
                    containerColor = Color.Transparent,
                )
            )
        }
    }
}

@ReelPreview
@Composable
private fun DetailPreview() {
    DetailScreen(
        detailNavActions = DetailNavActions(
            navigateToBack = {}
        ),
        state = DetailState(
            tvSeriesDetail = TvSeriesDetail(name = "Example")
        )
    )
}