package com.yeonberry.flicks.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.yeonberry.flicks.core.designsystem.ui.theme.Black
import com.yeonberry.flicks.core.designsystem.ui.theme.Gray
import com.yeonberry.flicks.core.model.Movie

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel()
) {
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()
    val itemList by viewModel.itemList.collectAsStateWithLifecycle()
    var query by rememberSaveable { mutableStateOf("") }
    val page by rememberSaveable { mutableIntStateOf(1) }

    Column {
        SearchBar(
            query = query,
            onValueChange = {
                query = it
                viewModel.searchMovies(query, page)
            }
        )
        when (searchState) {
            SearchResultUiState.Loading -> {

            }

            SearchResultUiState.LoadFailed -> {

            }

            is SearchResultUiState.Success -> {
                LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
                    this.items(itemList) { movie ->
                        MovieCard(movie)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onValueChange: (String) -> Unit = {},
) {
    TextField(
        value = query,
        onValueChange = {
            onValueChange(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.feature_search_placeholder))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
        GlideImage(
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(corner = CornerSize(2.dp))),
            model = movie.posterPath,
            failure = placeholder(ColorPainter(Gray)),
            contentDescription = stringResource(id = R.string.feature_search_movie_poster),
        )
        Column {
            Text(
                text = movie.title,
                color = Black,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Text(
                text = movie.releaseDate,
                color = Gray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 2.dp),
            )
        }
    }
}