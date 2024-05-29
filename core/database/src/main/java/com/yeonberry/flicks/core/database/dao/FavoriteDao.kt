package com.yeonberry.flicks.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yeonberry.flicks.core.database.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM movieentity")
    fun getFavorites(): Flow<List<MovieEntity>>

    @Insert
    fun insert(movie: MovieEntity)

    @Delete
    fun delete(movie: MovieEntity)
}