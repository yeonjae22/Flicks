package com.yeonberry.flicks.core.model

data class SearchResult(
    val page: String,
    val totalPages: String,
    val totalResults: String,
    val movies: List<Movie>
)