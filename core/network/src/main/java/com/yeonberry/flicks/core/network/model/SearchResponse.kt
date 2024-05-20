package com.yeonberry.flicks.core.network.model

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