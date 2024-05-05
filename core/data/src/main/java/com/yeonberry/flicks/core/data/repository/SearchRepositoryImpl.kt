package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.common.result.safeFlow
import com.yeonberry.flicks.core.data.mapper.SearchMapper.toDomain
import com.yeonberry.flicks.core.data.source.SearchDataSource
import com.yeonberry.flicks.core.model.SearchResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override fun searchMovies(query: String, page: Int): Flow<ApiResult<SearchResult>> {
        return safeFlow {
            dataSource.searchMovies(query, page).toDomain()
        }
    }
}