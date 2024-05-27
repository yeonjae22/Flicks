package com.yeonberry.kakao.feature.favorites

sealed interface FavoritesResultUiState {
    data object Loading : FavoritesResultUiState

    data object LoadFailed : FavoritesResultUiState

    data object Success : FavoritesResultUiState
}