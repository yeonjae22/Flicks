package com.yeonberry.flicks.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.domain.usecase.GetFavoritesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetNowPlayingMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetPopularMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.GetTrendingMoviesUseCase
import com.yeonberry.flicks.core.domain.usecase.UpdateFavoriteUseCase
import com.yeonberry.flicks.core.model.Movie
import com.yeonberry.flicks.core.model.NowPlayingResult
import com.yeonberry.flicks.core.model.PopularResult
import com.yeonberry.flicks.core.model.TrendingResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
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
                getPopularMoviesUseCase.invoke(),
                getFavoritesUseCase.invoke(),
            ) { trending, nowPlaying, popular, favorites ->
                HomeContent(trending, nowPlaying, popular, favorites)
            }.collectLatest { homeContent ->
                when (homeContent.trending) {
                    is ApiResult.Success -> {
                        val list = homeContent.trending.data.results.map {
                            if (homeContent.favorites.contains(it)) {
                                it.isFavorite = true
                            }
                            it
                        }
                        _trendingMovies.value = list
                    }

                    else -> {}
                }

                when (homeContent.nowPlaying) {
                    is ApiResult.Success -> {
                        _nowPlayingMovies.value = homeContent.nowPlaying.data.results
                    }

                    else -> {}
                }

                when (homeContent.popular) {
                    is ApiResult.Success -> {
                        _popularMovies.value = homeContent.popular.data.results
                    }

                    else -> {}
                }

                _homeState.value = HomeResultUiState.Success
            }
        }
    }

    fun updateFavorites(movie: Movie) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                updateFavoriteUseCase.invoke(movie)
            }
        }
    }
}

data class HomeContent(
    val trending: ApiResult<TrendingResult>,
    val nowPlaying: ApiResult<NowPlayingResult>,
    val popular: ApiResult<PopularResult>,
    val favorites: List<Movie>
)