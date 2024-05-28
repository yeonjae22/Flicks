package com.yeonberry.flicks.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.domain.usecase.GetNowPlayingMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetPopularMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetTrendingMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.UpdateFavoritesUseCase
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
    private val updateFavoritesUseCase: UpdateFavoritesUseCase
) : ViewModel() {

    private val _homeState: MutableStateFlow<HomeResultUiState> =
        MutableStateFlow(HomeResultUiState.Loading)
    val homeState: StateFlow<HomeResultUiState>
        get() = _homeState.asStateFlow()

    private val _trendingMovies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val trendingMovies: StateFlow<List<Movie>>
        get() = _trendingMovies.asStateFlow()

    private val _nowPlayingMovies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val nowPlayingMovies: StateFlow<List<Movie>>
        get() = _nowPlayingMovies.asStateFlow()

    private val _popularMovies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val popularMovies: StateFlow<List<Movie>>
        get() = _popularMovies.asStateFlow()

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
                        _trendingMovies.value = trending.value.results
                    }

                    else -> {}
                }

                when (nowPlaying) {
                    is ApiResult.Success -> {
                        _nowPlayingMovies.value = nowPlaying.value.results
                    }

                    else -> {}
                }

                when (popular) {
                    is ApiResult.Success -> {
                        _popularMovies.value = popular.value.results
                    }

                    else -> {}
                }


                _homeState.value = HomeResultUiState.Success
            }
        }
    }

    fun updateFavorites(movie: Movie) {
        viewModelScope.launch {
            updateFavoritesUseCase.invoke(movie)
        }
    }
}