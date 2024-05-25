package com.yeonberry.flicks.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.domain.usecase.GetNowPlayingMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetPopularMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetTrendingMoviesUseCase
import com.yeonberry.flicks.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
) : ViewModel() {

    private val _homeState: MutableStateFlow<HomeResultUiState> =
        MutableStateFlow(HomeResultUiState.Loading)
    val homeState: StateFlow<HomeResultUiState>
        get() = _homeState.asStateFlow()

    private val _trendingMovie: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val trendingMovie: StateFlow<List<Movie>>
        get() = _trendingMovie.asStateFlow()

    fun getHomeContents() {
        viewModelScope.launch {
            combine(
                getTrendingMoviesUseCase.invoke(),
                getNowPlayingMoviesUseCase.invoke(),
                getPopularMoviesUseCase.invoke()
            ) { trending, nowPlaying, popular ->
                Triple(trending, nowPlaying, popular)
            }.collectLatest { (trending, nowPlaying, popular) ->
                when (trending) {
                    is ApiResult.Success -> {
                        _homeState.value = HomeResultUiState.Success(trending.value.results)
                        _trendingMovie.value = trending.value.results
                    }

                    else -> {
                        _homeState.value = HomeResultUiState.LoadFailed
                    }
                }
            }
        }
    }
}