package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.common.result.safeFlow
import com.yeonberry.flicks.core.data.mapper.SearchMapper.asExternalModel
import com.yeonberry.flicks.core.model.SearchResult
import com.yeonberry.flicks.core.network.source.SearchDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override fun searchMovies(query: String, page: Int): Flow<ApiResult<SearchResult>> {
        return safeFlow {
            dataSource.searchMovies(query, page).asExternalModel()
        }
    }
}