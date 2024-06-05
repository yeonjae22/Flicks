package com.yeonberry.flicks.core.network.api

import com.yeonberry.flicks.core.network.model.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailsService {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: String,
        @Query("language") language: String = "ko"
    ): DetailResponse
}