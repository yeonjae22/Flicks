package com.yeonberry.flicks.model

data class Movie(
    val name: String,
    val releaseDate: String,
    val posterPath: String,
    val genreIds: List<String>
)