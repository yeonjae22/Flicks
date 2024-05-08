package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.common.result.safeFlow
import com.yeonberry.flicks.core.data.mapper.HomeMapper.toDomain
import com.yeonberry.flicks.core.data.source.HomeDataSource
import com.yeonberry.flicks.core.model.TrendingResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {

    override fun getTrendingMovies(): Flow<ApiResult<TrendingResult>> {
        return safeFlow {
            dataSource.getTrendingMovies().toDomain()
        }
    }
}