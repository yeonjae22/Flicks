package com.yeonberry.flicks.feature.home

import com.yeonberry.flicks.core.model.Movie

sealed interface HomeResultUiState {
    data object Loading : HomeResultUiState

    data object LoadFailed : HomeResultUiState

    data class Success(
        val movies: List<Movie> = emptyList()
    ) : HomeResultUiState {
        fun isEmpty(): Boolean = movies.isEmpty()
    }
}