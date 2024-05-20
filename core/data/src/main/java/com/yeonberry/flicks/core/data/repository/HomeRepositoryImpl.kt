package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.common.result.safeFlow
import com.yeonberry.flicks.core.data.mapper.HomeMapper.asExternalModel
import com.yeonberry.flicks.core.model.NowPlayingResult
import com.yeonberry.flicks.core.model.PopularResult
import com.yeonberry.flicks.core.model.TrendingResult
import com.yeonberry.flicks.core.network.source.HomeDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {

    override fun getTrendingMovies(): Flow<ApiResult<TrendingResult>> {
        return safeFlow {
            dataSource.getTrendingMovies().asExternalModel()
        }
    }

    override fun getNowPlayingMovies(): Flow<ApiResult<NowPlayingResult>> {
        return safeFlow {
            dataSource.getNowPlayingMovies().asExternalModel()
        }
    }

    override fun getPopularMovies(): Flow<ApiResult<PopularResult>> {
        return safeFlow {
            dataSource.getPopularMovies().asExternalModel()
        }
    }
}