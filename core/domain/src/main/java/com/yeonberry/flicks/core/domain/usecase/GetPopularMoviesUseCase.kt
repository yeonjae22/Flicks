package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.data.repository.HomeRepository
import com.yeonberry.flicks.core.model.PopularResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: HomeRepository
) {

    operator fun invoke(): Flow<ApiResult<PopularResult>> = repository.getPopularMovies()
}