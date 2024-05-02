package com.yeonberry.flicks.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("page")
    val page: String,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: String,
    @SerializedName("total_results")
    val totalResults: String
)

data class Movie(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<String>
)