package com.yeonberry.flicks.core.database.di

import com.yeonberry.flicks.core.database.FlicksDataBase
import com.yeonberry.flicks.core.database.dao.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    fun providesFavoriteDao(
        database: FlicksDataBase,
    ): FavoriteDao = database.favoriteDao()
}
