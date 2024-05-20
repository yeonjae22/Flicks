package com.yeonberry.flicks.core.network.source

import com.yeonberry.flicks.core.network.api.SearchService
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    private val service: SearchService
) {
    suspend fun searchMovies(query: String, page: Int) =
        service.searchMovies(query = query, page = page)
}