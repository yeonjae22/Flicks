package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
    fun getMovieDetail(movieId: String): Flow<ApiResult<MovieDetail>>
}