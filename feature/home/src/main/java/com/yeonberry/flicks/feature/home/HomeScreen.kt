package com.yeonberry.flicks.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yeonberry.flicks.core.designsystem.R.drawable
import com.yeonberry.flicks.core.designsystem.ui.theme.Gray200
import com.yeonberry.flicks.core.designsystem.ui.theme.Gray400
import com.yeonberry.flicks.core.designsystem.ui.theme.Gray900
import com.yeonberry.flicks.core.designsystem.ui.theme.Pink100
import com.yeonberry.flicks.core.designsystem.ui.theme.Red500
import com.yeonberry.flicks.core.designsystem.ui.theme.White
import com.yeonberry.flicks.core.model.Movie


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onSearchBarClick: () -> Unit
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()
    val trendingMovies by viewModel.trendingMovies.collectAsStateWithLifecycle()
    val nowPlayingMovies by viewModel.nowPlayingMovies.collectAsStateWithLifecycle()
    val popularMovies by viewModel.popularMovies.collectAsStateWithLifecycle()

    viewModel.getHomeContents()

    when (homeState) {
        HomeResultUiState.Loading -> {

        }

        HomeResultUiState.LoadFailed -> {

        }

        HomeResultUiState.Success -> {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item {
                    SearchBar(onClick = onSearchBarClick)
                }
                item {
                    MoviesSection(
                        title = stringResource(id = R.string.feature_home_trending_section_title),
                        movies = trendingMovies,
                        onToggleFavorite = {
                            viewModel.updateFavorites(it)
                        }
                    )
                }
                item {
                    MoviesSection(
                        title = stringResource(id = R.string.feature_home_nowPlaying_section_title),
                        movies = nowPlayingMovies,
                        onToggleFavorite = {
                            viewModel.updateFavorites(it)
                        }
                    )
                }
                item {
                    MoviesSection(
                        title = stringResource(id = R.string.feature_home_popular_section_title),
                        movies = popularMovies,
                        onToggleFavorite = {
                            viewModel.updateFavorites(it)
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar(onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(corner = CornerSize(14.dp)))
            .clickable { onClick() }
            .background(Gray200)
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = stringResource(R.string.feature_home_placeholder),
            color = Gray400,
            style = MaterialTheme.typography.bodyLarge
        )
    }

//    val interactionSource = remember { MutableInteractionSource() }
//
//    BasicTextField(
//        value = "",
//        modifier = Modifier
//            .clickable {
//                onClick()
//            }
//            .fillMaxWidth()
//            .padding(16.dp),
//        onValueChange = {},
//        enabled = false,
//        readOnly = true,
//        singleLine = true,
//        maxLines = 1,
//        decorationBox = @Composable { innerTextField ->
//            TextFieldDefaults.DecorationBox(
//                value = "",
//                visualTransformation = VisualTransformation.None,
//                innerTextField = innerTextField,
//                placeholder = {
//                    Text(stringResource(R.string.feature_home_placeholder))
//                },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Rounded.Search,
//                        contentDescription = null,
//                        tint = MaterialTheme.colorScheme.onSurface,
//                    )
//                },
//                shape = RoundedCornerShape(14.dp),
//                singleLine = true,
//                enabled = false,
//                interactionSource = interactionSource,
//                contentPadding = PaddingValues(2.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent,
//                )
//            )
//        }
//    )
}

@Composable
private fun MoviesSection(
    modifier: Modifier = Modifier,
    title: String,
    movies: List<Movie>,
    onToggleFavorite: (Movie) -> Unit
) {
    Column(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = title,
            color = Gray900,
            style = MaterialTheme.typography.bodyLarge
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(movies) { movie ->
                MovieCard(movie = movie, onToggleFavorite = onToggleFavorite)
            }
        }
    }
}

@Composable
private fun MovieCard(
    movie: Movie,
    onToggleFavorite: (Movie) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(130.dp)
//            .clickable(onClick = { onClick(movie) })
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                // placeholder = painterResource(R.drawable.placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(186.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(2.dp)))
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop,
            )
            IconToggleButton(
                checked = movie.isFavorite,
                onCheckedChange = { onToggleFavorite(movie) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = if (movie.isFavorite) painterResource(id = drawable.baseline_favorite_24) else painterResource(
                        id = drawable.baseline_favorite_border_24
                    ),
                    contentDescription = null,
                    tint = Pink100
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = movie.title,
            color = Gray900,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = movie.releaseDate,
            color = Gray400,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(2.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = drawable.baseline_star_24),
                contentDescription = null,
                tint = Red500,
            )
            Text(
                text = movie.voteAverage,
                color = Gray900,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 2.dp),
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(onClick = {})
}

@Preview
@Composable
fun MoviesSectionPreview() {
    MoviesSection(
        title = stringResource(id = R.string.feature_home_trending_section_title),
        movies = listOf(
            Movie(
                id = "1234",
                title = "movie title movie title movie title movie title movie title",
                releaseDate = "2024.09.08",
                posterPath = "",
                genreIds = emptyList(),
                overview = "movie overview movie overview movie overview movie overview movie overview",
                voteAverage = "9.8",
                isFavorite = false
            ),
            Movie(
                id = "1234",
                title = "movie title movie title movie title movie title movie title",
                releaseDate = "2024.09.08",
                posterPath = "",
                genreIds = emptyList(),
                overview = "movie overview movie overview movie overview movie overview movie overview",
                voteAverage = "9.8",
                isFavorite = true
            )
        ),
        onToggleFavorite = {}
    )
}