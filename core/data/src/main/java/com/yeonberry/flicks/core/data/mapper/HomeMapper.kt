package com.yeonberry.flicks.core.data.mapper

import com.yeonberry.flicks.core.model.Movie
import com.yeonberry.flicks.core.model.NowPlayingResult
import com.yeonberry.flicks.core.model.PopularResult
import com.yeonberry.flicks.core.model.TrendingResult
import com.yeonberry.flicks.core.network.model.NowPlayingResponse
import com.yeonberry.flicks.core.network.model.PopularResponse
import com.yeonberry.flicks.core.network.model.TrendingResponse

object HomeMapper {
    fun TrendingResponse.asExternalModel() = TrendingResult(
        results = results.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                posterPath = "https://image.tmdb.org/t/p/w342/" + it.posterPath,
                genreIds = it.genreIds,
                overview = it.overview,
                voteAverage = it.voteAverage,
                isFavorite = false
            )
        }
    )

    fun NowPlayingResponse.asExternalModel() = NowPlayingResult(
        results = results.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                posterPath = "https://image.tmdb.org/t/p/w342/" + it.posterPath,
                genreIds = it.genreIds,
                overview = it.overview,
                voteAverage = it.voteAverage,
                isFavorite = false
            )
        }
    )

    fun PopularResponse.asExternalModel() = PopularResult(
        results = results.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                posterPath = "https://image.tmdb.org/t/p/w342/" + it.posterPath,
                genreIds = it.genreIds,
                overview = it.overview,
                voteAverage = it.voteAverage,
                isFavorite = false
            )
        }
    )
}