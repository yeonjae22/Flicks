package com.yeonberry.flicks.feature.home

sealed interface HomeResultUiState {
    data object Loading : HomeResultUiState

    data object LoadFailed : HomeResultUiState

    data object Success : HomeResultUiState
}