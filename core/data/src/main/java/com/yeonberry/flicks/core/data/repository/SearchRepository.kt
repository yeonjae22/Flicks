package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.model.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun searchMovies(query: String, page: Int): Flow<ApiResult<SearchResult>>
}