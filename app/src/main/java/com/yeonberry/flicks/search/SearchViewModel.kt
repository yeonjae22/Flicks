package com.yeonberry.flicks.search

import androidx.lifecycle.ViewModel
import com.yeonberry.flicks.domain.usecase.GetSearchMoviesUseCase
import com.yeonberry.flicks.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchMoviesUseCase: GetSearchMoviesUseCase
) : ViewModel() {

    private val _searchState: MutableStateFlow<SearchResultUiState> =
        MutableStateFlow(SearchResultUiState.Loading)
    val searchState: StateFlow<SearchResultUiState>
        get() = _searchState.asStateFlow()

    private val _itemList: MutableStateFlow<List<Movie>> =
        MutableStateFlow(emptyList())
    val itemList: StateFlow<List<Movie>>
        get() = _itemList.asStateFlow()

    fun searchMovies(query: String, page: Int) {
        getSearchMoviesUseCase.invoke(query = query, page = page)
    }
}