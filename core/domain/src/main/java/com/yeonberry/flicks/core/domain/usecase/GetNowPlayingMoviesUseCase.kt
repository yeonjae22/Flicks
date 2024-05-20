package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.data.repository.HomeRepository
import com.yeonberry.flicks.core.model.NowPlayingResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val repository: HomeRepository
) {

    operator fun invoke(): Flow<ApiResult<NowPlayingResult>> = repository.getNowPlayingMovies()
}