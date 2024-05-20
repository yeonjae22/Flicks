package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.model.NowPlayingResult
import com.yeonberry.flicks.core.model.PopularResult
import com.yeonberry.flicks.core.model.TrendingResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getTrendingMovies(): Flow<ApiResult<TrendingResult>>
    fun getNowPlayingMovies(): Flow<ApiResult<NowPlayingResult>>
    fun getPopularMovies(): Flow<ApiResult<PopularResult>>
}