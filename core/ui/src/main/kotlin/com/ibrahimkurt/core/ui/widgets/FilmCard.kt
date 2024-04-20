package com.ibrahimkurt.core.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.ibrahimkurt.core.component.ReelPreview
import com.ibrahimkurt.core.component.extensions.surface
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme
import com.ibrahimkurt.core.ui.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilmCard(
    model: Any? = R.drawable.examplefastx,
    title: String,
    width: Dp = 160.dp,
    contentDescription: String? = null,
) {
    val roundedCornerShapePx = with(LocalDensity.current) { 4.dp.toPx() }
    val bottomHeight = 80.dp
   val height: Dp = (width.value * 1.5f).dp

    Column(
        modifier = Modifier
            .padding(8.dp)
            .height(height + bottomHeight)
            .width(160.dp)
            .surface(RoundedCornerShape(4.dp), Color.White, null, 10f),

        ) {
        Box(
            modifier = Modifier
                .height(height)
                .background(Color.LightGray.copy(0.2f))

        ) {
            val context = LocalContext.current
            val imageLoader = context.imageLoader
            val request = ImageRequest.Builder(LocalContext.current)
                .data(model)
                .transformations(
                    RoundedCornersTransformation(radius = roundedCornerShapePx),
                )
                .crossfade(true)
                .build()
            AsyncImage(
                model = request,
                contentDescription = contentDescription,
                imageLoader = imageLoader,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .height(bottomHeight)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@ReelPreview
@Composable
private fun FilmCardPreview() {
    MultiModReelComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(160.dp),
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                items(count = 200) { _ ->

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(320.dp)
                    ) {
                        FilmCard(
                            title = "Peaky Blinders"
                        )
                    }
                }
            }
        }
    }
}