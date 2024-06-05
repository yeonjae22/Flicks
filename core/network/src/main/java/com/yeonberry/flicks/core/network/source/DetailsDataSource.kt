package com.yeonberry.flicks.core.network.source

import com.yeonberry.flicks.core.network.api.DetailsService
import javax.inject.Inject

class DetailsDataSource @Inject constructor(
    private val service: DetailsService
) {
    suspend fun getMovieDetail(movieId: String) = service.getMovieDetail(movieId = movieId)
}