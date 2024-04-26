package com.yeonberry.flicks.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yeonberry.flicks.domain.usecase.GetSearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getSearchMoviesUseCase: GetSearchMoviesUseCase
) : ViewModel() {


    fun searchMovies() {

    }
}