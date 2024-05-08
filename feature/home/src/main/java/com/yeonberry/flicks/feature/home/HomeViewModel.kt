package com.yeonberry.flicks.feature.home

import androidx.lifecycle.ViewModel
import com.yeonberry.flicks.core.domain.usecase.GetTrendingMoviesUseCase
import com.yeonberry.flicks.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase
) : ViewModel() {

    private val _homeState: MutableStateFlow<HomeResultUiState> =
        MutableStateFlow(HomeResultUiState.Loading)
    val homeState: StateFlow<HomeResultUiState>
        get() = _homeState.asStateFlow()

    private val _itemList: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val itemList: StateFlow<List<Movie>>
        get() = _itemList.asStateFlow()
}