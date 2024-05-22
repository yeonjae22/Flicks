package com.yeonberry.flicks.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.yeonberry.flicks.core.designsystem.ui.theme.Gray400
import com.yeonberry.flicks.core.model.Movie


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()
    val itemList by viewModel.itemList.collectAsStateWithLifecycle()

    Column {
        when (val state = homeState) {
            HomeResultUiState.Loading -> {

            }

            HomeResultUiState.LoadFailed -> {

            }

            is HomeResultUiState.Success -> {
                TrendingMoviesSection(movies = state.movies)
            }
        }
    }
}

@Composable
private fun TrendingMoviesSection(
    modifier: Modifier = Modifier,
    movies: List<Movie>
) {
    Column {
        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.feature_home_popular_section_title),
            style = MaterialTheme.typography.titleLarge
        )
        LazyRow(modifier = modifier.padding(horizontal = 16.dp)) {
            this.items(movies) { movie ->
                MovieCard(movie)
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }

    val imageLoader = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(movie.posterPath)
            .crossfade(true)
            .build(),
        onState = { state ->
            isLoading = state is AsyncImagePainter.State.Loading
            isError = state is AsyncImagePainter.State.Error
        })

    Column {
        Image(
            modifier = Modifier
                .width(130.dp)
                .height(186.dp)
                .clip(RoundedCornerShape(corner = CornerSize(2.dp))),
            contentScale = ContentScale.Crop,
            painter = if (isError.not()) {
                imageLoader
            } else {
                painterResource(Gray400.hashCode())
            },
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = movie.voteAverage,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = movie.title,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = movie.releaseDate,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun TrendingMoviesSectionPreview() {
    // TrendingMoviesSection()
}