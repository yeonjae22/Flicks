package com.yeonberry.flicks.data.repository

import com.yeonberry.flicks.data.ApiResult
import com.yeonberry.flicks.data.mapper.SearchMapper.toDomain
import com.yeonberry.flicks.data.safeFlow
import com.yeonberry.flicks.data.source.SearchDataSource
import com.yeonberry.flicks.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override fun searchMovies(query: String, page: Int): Flow<ApiResult<List<Movie>>> {
        return safeFlow {
            dataSource.searchMovies(query, page).toDomain()
        }
    }
}