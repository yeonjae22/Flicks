package com.yeonberry.flicks.feature.search

sealed interface SearchResultUiState {
    data object Loading : SearchResultUiState

    data object LoadFailed : SearchResultUiState

    data object Success : SearchResultUiState
}