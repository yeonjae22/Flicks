package com.yeonberry.kakao.feature.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeonberry.flicks.core.domain.usecase.GetFavoritesUseCase
import com.yeonberry.flicks.core.domain.usecase.UpdateFavoritesUseCase
import com.yeonberry.flicks.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val updateFavoritesUseCase: UpdateFavoritesUseCase
) : ViewModel() {

    private val _favoritesState: MutableStateFlow<FavoritesResultUiState> =
        MutableStateFlow(FavoritesResultUiState.Loading)
    val favoritesState: StateFlow<FavoritesResultUiState>
        get() = _favoritesState.asStateFlow()

    private val _itemList: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val itemList: StateFlow<List<Movie>>
        get() = _itemList.asStateFlow()

    fun getFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase.invoke().collectLatest {
                _itemList.emit(it)
            }
        }
    }

    fun updateFavorites(favorites: List<Movie>) {
        viewModelScope.launch {
            updateFavoritesUseCase.invoke(favorites)
        }
    }
}