package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.data.repository.HomeRepository
import com.yeonberry.flicks.core.model.TrendingResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: HomeRepository
) {

    operator fun invoke(): Flow<ApiResult<TrendingResult>> = repository.getTrendingMovies()
}