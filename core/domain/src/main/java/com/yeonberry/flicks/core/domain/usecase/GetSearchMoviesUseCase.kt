package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.data.repository.SearchRepository
import com.yeonberry.flicks.core.model.SearchResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchMoviesUseCase @Inject constructor(
    private val searchMovies: SearchRepository
) {

    operator fun invoke(query: String, page: Int): Flow<ApiResult<SearchResult>> =
        searchMovies.searchMovies(query, page)
}