package com.yeonberry.flicks.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yeonberry.flicks.core.database.dao.FavoriteDao
import com.yeonberry.flicks.core.database.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class FlicksDataBase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}