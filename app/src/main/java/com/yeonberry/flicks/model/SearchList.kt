package com.yeonberry.flicks.model

data class SearchList(
    val page: String,
    val totalPages: String,
    val totalResults: String,
    val movies: List<Movie>
)