package com.yeonberry.flicks.domain.usecase

import com.yeonberry.flicks.data.ApiResult
import com.yeonberry.flicks.data.repository.SearchRepository
import com.yeonberry.flicks.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchMoviesUseCase @Inject constructor(
    private val searchMovies: SearchRepository
) {

    operator fun invoke(query: String, page: Int): Flow<ApiResult<List<Movie>>> =
        searchMovies.searchMovies(query, page)
}