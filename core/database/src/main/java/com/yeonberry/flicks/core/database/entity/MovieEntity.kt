package com.yeonberry.flicks.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yeonberry.flicks.core.model.Movie

@Entity
data class MovieEntity(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @ColumnInfo(name = "posterPath") val posterPath: String,
    @ColumnInfo(name = "genreIds") val genreIds: List<String>,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "voteAverage") val voteAverage: String,
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean
)

fun MovieEntity.asExternalModel() = Movie(
    id = uid,
    title = title,
    releaseDate = releaseDate,
    posterPath = posterPath,
    genreIds = genreIds,
    overview = overview,
    voteAverage = voteAverage,
    isFavorite = isFavorite
)