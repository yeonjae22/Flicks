package com.yeonberry.flicks.data.mapper

import com.yeonberry.flicks.data.model.SearchResponse
import com.yeonberry.flicks.model.Movie

object SearchMapper {
    fun List<SearchResponse>.toDomain() = this.map {
        Movie(
            name = it.name,
            releaseDate = it.releaseDate,
            posterPath = it.posterPath,
            genreIds = it.genreIds
        )
    }
}