package com.yeonberry.kakao.feature.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yeonberry.flicks.core.designsystem.ui.theme.Gray900
import com.yeonberry.flicks.core.designsystem.ui.theme.White
import com.yeonberry.flicks.core.model.Movie

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val favoritesState by viewModel.favoritesState.collectAsStateWithLifecycle()
    val itemList by viewModel.itemList.collectAsStateWithLifecycle()

    viewModel.getFavorites()

    when (favoritesState) {
        FavoritesResultUiState.Loading -> {

        }

        FavoritesResultUiState.LoadFailed -> {

        }

        FavoritesResultUiState.Success -> {
            Favorites(modifier = modifier, itemList = itemList)
        }
    }
}

@Composable
private fun Favorites(modifier: Modifier = Modifier, itemList: List<Movie>) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .background(White),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemList) { movie ->
            MovieCard(movie)
        }
    }
}

@Composable
private fun MovieCard(movie: Movie) {
    Column(
        modifier = Modifier.width(130.dp)
    ) {
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
                .clip(RoundedCornerShape(corner = CornerSize(2.dp))),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = movie.title,
            color = Gray900,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun FavoritesPreview() {
    Favorites(
        itemList = listOf(
            Movie(
                id = "1234",
                title = "movie title movie title movie title movie title movie title",
                releaseDate = "2024.09.08",
                posterPath = "",
                genreIds = emptyList(),
                overview = "movie overview movie overview movie overview movie overview movie overview",
                voteAverage = "9.8",
                isFavorite = true
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
        )
    )
}