package com.yeonberry.flicks.core.network.source

import com.yeonberry.flicks.core.network.api.HomeService
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val service: HomeService
) {
    suspend fun getTrendingMovies() = service.getTrendingMovies()
}