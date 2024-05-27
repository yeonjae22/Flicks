package com.yeonberry.kakao.feature.favorites

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
) : ViewModel() {

    private val _favoritesState: MutableStateFlow<FavoritesResultUiState> =
        MutableStateFlow(FavoritesResultUiState.Loading)
    val favoritesState: StateFlow<FavoritesResultUiState>
        get() = _favoritesState.asStateFlow()
}