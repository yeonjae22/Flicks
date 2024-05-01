package com.yeonberry.flicks.data.repository

import com.yeonberry.flicks.data.util.ApiResult
import com.yeonberry.flicks.model.SearchList
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun searchMovies(query: String, page: Int): Flow<ApiResult<SearchList>>
}