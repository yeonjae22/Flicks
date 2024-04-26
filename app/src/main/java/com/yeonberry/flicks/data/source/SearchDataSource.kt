package com.yeonberry.flicks.data.source

import com.yeonberry.flicks.data.api.SearchService
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    private val service: SearchService
) {
    suspend fun searchMovies(query: String, page: Int) =
        service.searchMovies(query = query, page = page)
}