package com.yeonberry.flicks.core.data.mapper

import com.yeonberry.flicks.core.model.Movie
import com.yeonberry.flicks.core.model.SearchResult
import com.yeonberry.flicks.core.network.model.SearchResponse

object SearchMapper {
    fun SearchResponse.asExternalModel() = SearchResult(
        page = page,
        totalPages = totalPages,
        totalResults = totalResults,
        results = results.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                posterPath = "https://image.tmdb.org/t/p/w342/" + it.posterPath,
                genreIds = it.genreIds,
                overview = it.overview,
                voteAverage = it.voteAverage
            )
        }
    )
}