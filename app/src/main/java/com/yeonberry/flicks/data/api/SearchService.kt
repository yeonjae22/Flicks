package com.yeonberry.flicks.data.api

import com.yeonberry.flicks.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("language") language: String = "ko"
    ): List<SearchResponse>
}