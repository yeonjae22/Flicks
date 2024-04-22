package com.yeonberry.flicks.search

import com.yeonberry.flicks.model.Movie

sealed interface SearchResultUiState {
    data object Loading : SearchResultUiState

    data object EmptyQuery : SearchResultUiState

    data object LoadFailed : SearchResultUiState

    data class Success(
        val movies: List<Movie> = emptyList()
    ) : SearchResultUiState {
        fun isEmpty(): Boolean = movies.isEmpty()
    }
}