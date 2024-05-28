package com.yeonberry.flicks.core.model

data class Movie(
    val id: String,
    val title: String,
    val releaseDate: String,
    val posterPath: String,
    val genreIds: List<String>,
    val overview: String,
    val voteAverage: String,
    val isFavorite: Boolean
)