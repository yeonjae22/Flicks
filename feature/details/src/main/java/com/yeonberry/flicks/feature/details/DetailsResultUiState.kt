package com.yeonberry.flicks.feature.details

sealed interface DetailsResultUiState {
    data object Loading : DetailsResultUiState

    data object LoadFailed : DetailsResultUiState

    data object Success : DetailsResultUiState
}