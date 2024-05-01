package com.yeonberry.flicks.data.mapper

import com.yeonberry.flicks.data.model.SearchResponse
import com.yeonberry.flicks.model.Movie
import com.yeonberry.flicks.model.SearchList

object SearchMapper {
    fun SearchResponse.toDomain() = SearchList(
        page = page,
        totalPages = totalPages,
        totalResults = totalResults,
        movies = results.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                genreIds = it.genreIds
            )
        }
    )
}