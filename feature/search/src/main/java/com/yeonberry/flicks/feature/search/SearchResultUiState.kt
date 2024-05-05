package com.yeonberry.flicks.feature.search

import com.yeonberry.flicks.core.model.Movie

sealed interface SearchResultUiState {
    data object Loading : SearchResultUiState

    data object LoadFailed : SearchResultUiState

    data class Success(
        val movies: List<Movie> = emptyList()
    ) : SearchResultUiState {
        fun isEmpty(): Boolean = movies.isEmpty()
    }
}