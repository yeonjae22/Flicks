package com.yeonberry.flicks.model

data class Movie(
    val id: String,
    val title: String,
    val releaseDate: String,
    val posterPath: String,
    val genreIds: List<String>
)