package com.yeonberry.flicks.core.database.di

import android.content.Context
import androidx.room.Room
import com.yeonberry.flicks.core.database.FlicksDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesFlicksDataBase(
        @ApplicationContext context: Context,
    ): FlicksDataBase = Room.databaseBuilder(
        context,
        FlicksDataBase::class.java,
        "flicks-database",
    ).build()
}