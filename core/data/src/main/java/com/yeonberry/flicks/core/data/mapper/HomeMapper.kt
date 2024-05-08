package com.yeonberry.flicks.core.data.mapper

import com.yeonberry.flicks.core.model.Movie
import com.yeonberry.flicks.core.model.TrendingResult
import com.yeonberry.flicks.core.network.model.TrendingResponse

object HomeMapper {
    fun TrendingResponse.toDomain() = TrendingResult(
        results = results.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                posterPath = "https://image.tmdb.org/t/p/w300/" + it.posterPath,
                genreIds = it.genreIds
            )
        }
    )
}