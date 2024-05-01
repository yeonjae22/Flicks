package com.yeonberry.flicks.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeonberry.flicks.data.util.ApiResult
import com.yeonberry.flicks.domain.usecase.GetSearchMoviesUseCase
import com.yeonberry.flicks.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchMoviesUseCase: GetSearchMoviesUseCase
) : ViewModel() {

    private val _searchState: MutableStateFlow<SearchResultUiState> =
        MutableStateFlow(SearchResultUiState.Loading)
    val searchState: StateFlow<SearchResultUiState>
        get() = _searchState.asStateFlow()

    private val _itemList: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val itemList: StateFlow<List<Movie>>
        get() = _itemList.asStateFlow()

    fun searchMovies(query: String, page: Int) {
        viewModelScope.launch {
            getSearchMoviesUseCase.invoke(query = query, page = page).collectLatest { apiResult ->
                when (apiResult) {
                    is ApiResult.Success -> {
                        _searchState.value = SearchResultUiState.Success(apiResult.value.movies)
                    }

                    else -> {
                        _searchState.value = SearchResultUiState.LoadFailed
                    }
                }
            }
        }
    }
}