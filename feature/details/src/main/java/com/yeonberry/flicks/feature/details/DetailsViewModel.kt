package com.yeonberry.flicks.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _detailsState: MutableStateFlow<DetailsResultUiState> =
        MutableStateFlow(DetailsResultUiState.Loading)
    val detailsState: StateFlow<DetailsResultUiState>
        get() = _detailsState.asStateFlow()

    fun getMovieDetail(movieId: String) {
        viewModelScope.launch {
            getMovieDetailUseCase.invoke(movieId).collectLatest { apiResult ->
                when (apiResult) {
                    is ApiResult.Success -> {
                        _detailsState.value = DetailsResultUiState.Success
                        apiResult.data.results
                    }

                    else -> {
                        _detailsState.value = DetailsResultUiState.LoadFailed
                    }
                }
            }
        }
    }
}