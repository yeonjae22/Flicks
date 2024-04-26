package com.yeonberry.flicks.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("documents")
    val name: String,
    @SerializedName("documents")
    val releaseDate: String,
    @SerializedName("documents")
    val posterPath: String,
    @SerializedName("documents")
    val genreIds: List<String>
)