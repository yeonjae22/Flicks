package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.common.result.ApiResult
import com.yeonberry.flicks.core.data.repository.DetailsRepository
import com.yeonberry.flicks.core.model.MovieDetail
import com.yeonberry.flicks.core.model.SearchResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: DetailsRepository
) {

    operator fun invoke(movieId: String): Flow<ApiResult<MovieDetail>> =
        repository.getMovieDetail(movieId)
}