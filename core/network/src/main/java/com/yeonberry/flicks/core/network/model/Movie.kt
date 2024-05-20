package com.yeonberry.flicks.core.network.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<String>,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("vote_average")
    val voteAverage: String
)