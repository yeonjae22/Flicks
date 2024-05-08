package com.yeonberry.flicks.core.network.api

import com.yeonberry.flicks.core.network.model.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeService {
    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String = "day",
        @Query("language") language: String = "ko"
    ): TrendingResponse
}