package com.yeonberry.flicks.domain.usecase

import com.yeonberry.flicks.data.repository.SearchRepository
import com.yeonberry.flicks.data.util.ApiResult
import com.yeonberry.flicks.model.SearchList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchMoviesUseCase @Inject constructor(
    private val searchMovies: SearchRepository
) {

    operator fun invoke(query: String, page: Int): Flow<ApiResult<SearchList>> =
        searchMovies.searchMovies(query, page)
}