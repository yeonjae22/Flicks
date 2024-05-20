package com.yeonberry.flicks.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yeonberry.flicks.core.model.Movie



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()
    // val itemList by viewModel.itemList.collectAsStateWithLifecycle()

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

}