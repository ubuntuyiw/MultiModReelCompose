package com.ibrahimkurt.core.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.ibrahimkurt.core.component.ReelPreview
import com.ibrahimkurt.core.component.extensions.surface
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme
import com.ibrahimkurt.core.ui.R

@Composable
fun FilmCard(
    model: Any? = R.drawable.examplefastx,
    title: String,
    date: String,
    voteAverage: Float,
    voteAverageFormat: String,
    width: Dp = 160.dp,
    contentDescription: String? = null,
    onClick: () -> Unit,

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
                .clickable(onClick = onClick)
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 4.dp)
            ) {
                CircularProgressIndicator(
                    progress = { voteAverage / 10 },
                    strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
                    trackColor = MaterialTheme.colorScheme.tertiary.copy(0.5f),
                    color = MaterialTheme.colorScheme.tertiary,
                    strokeWidth = 2.dp,
                    modifier = Modifier
                        .size(32.dp)
                        .offset(y = 16.dp)
                        .clip(CircleShape)
                        .background(Color.Black)
                )
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.offset(y = 16.dp).background(Color.Black.copy(0.5f))
                ) {
                    val getAnnotatedTermsAndPrivacyText = buildAnnotatedString {
                        append("$voteAverageFormat%")
                        val start = voteAverageFormat.length
                        val end = voteAverageFormat.length + 1

                        val style = MaterialTheme.typography.labelSmall.copy().toSpanStyle()

                        addStyle(style, start, end)
                        addStringAnnotation(
                            tag = "URL",
                            annotation = voteAverageFormat,
                            start = start,
                            end = end
                        )
                    }
                    Text(
                        text = getAnnotatedTermsAndPrivacyText,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontSize = 10.sp
                        ),
                        modifier = Modifier

                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 20.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(bottomHeight)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp
                ),
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
                            title = "Peaky Blinders",
                            date = "20-09-2019",
                            voteAverage = 8.5f,
                            voteAverageFormat = "8.5f"
                        ) {}
                    }
                }
            }
        }
    }
}