package com.yeonberry.flicks.core.network.model

import com.google.gson.annotations.SerializedName

data class TrendingResponse(
    @SerializedName("results")
    val results: List<Movie>
)