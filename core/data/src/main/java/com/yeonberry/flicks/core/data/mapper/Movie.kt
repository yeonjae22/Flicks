package com.yeonberry.flicks.core.data.mapper

import com.yeonberry.flicks.core.database.entity.MovieEntity
import com.yeonberry.flicks.core.model.Movie

fun Movie.asEntity() = MovieEntity(
    uid = id,
    title = title,
    releaseDate = releaseDate,
    posterPath = posterPath,
    genreIds = genreIds,
    overview = overview,
    voteAverage = voteAverage,
    isFavorite = isFavorite
)