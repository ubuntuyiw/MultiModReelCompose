package com.ibrahimkurt.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.ibrahimkurt.core.component.ReelPreview
import com.ibrahimkurt.core.ui.widgets.FilmCard
import com.ibrahimkurt.features.home.domain.model.TvShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeRoute(homeNavActions: HomeNavActions) {
    val viewModel: HomeViewModel = hiltViewModel()
    val homePage = viewModel.homePaging.collectAsLazyPagingItems()
    HomeScreen(
        homeNavActions = homeNavActions,
        homePage = homePage
    )
}

@Composable
fun HomeScreen(
    homeNavActions: HomeNavActions,
    homePage: LazyPagingItems<TvShow>
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(160.dp),
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(count = homePage.itemCount) { index ->
            val item = homePage[index] ?: TvShow()

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(4.dp)
            ) {
                FilmCard(
                    model = "https://image.tmdb.org/t/p/w500" + item.posterPath,
                    title = item.name,
                    date = item.firstAirDate,
                    voteAverage = item.voteAverage,
                    voteAverageFormat = item.voteAverageFormat
                ) {
                    homeNavActions.navigateToDetail()
                }
            }
        }
    }
}

@ReelPreview
@Composable
fun HomePreview() {
    val pagingDataFlow: Flow<PagingData<TvShow>> = flowOf(
        PagingData.from(
            listOf(
                TvShow(name = "example"),
                TvShow(name = "example1"),
                TvShow(name = "example2"),
            )
        )
    )
    HomeScreen(
        homeNavActions = HomeNavActions(
            navigateToDetail = {}
        ),
        homePage = pagingDataFlow.collectAsLazyPagingItems()
    )
}