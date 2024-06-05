package com.yeonberry.flicks.core.data.mapper

import com.yeonberry.flicks.core.model.MovieDetail
import com.yeonberry.flicks.core.network.model.DetailResponse

fun DetailResponse.asExternalModel() = MovieDetail(
    id = id,
    title = title,
    releaseDate = releaseDate,
    posterPath = "https://image.tmdb.org/t/p/w342/$posterPath",
    genreIds = genreIds,
    overview = overview,
    voteAverage = voteAverage,
    runtime = runtime,
    isFavorite = false
)
