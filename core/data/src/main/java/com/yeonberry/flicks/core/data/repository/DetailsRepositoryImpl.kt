package com.yeonberry.flicks.core.data.repository

import com.yeonberry.common.result.ApiResult
import com.yeonberry.common.result.safeFlow
import com.yeonberry.flicks.core.data.mapper.asExternalModel
import com.yeonberry.flicks.core.model.MovieDetail
import com.yeonberry.flicks.core.network.api.DetailsService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val dataSource: DetailsService
) : DetailsRepository {
    override fun getMovieDetail(movieId: String): Flow<ApiResult<MovieDetail>> {
        return safeFlow {
            dataSource.getMovieDetail(movieId).asExternalModel()
        }
    }
}