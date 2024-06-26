package com.yeonberry.flicks.core.data.di

import com.yeonberry.flicks.core.data.repository.DetailsRepository
import com.yeonberry.flicks.core.data.repository.DetailsRepositoryImpl
import com.yeonberry.flicks.core.data.repository.FavoritesRepository
import com.yeonberry.flicks.core.data.repository.FavoritesRepositoryImpl
import com.yeonberry.flicks.core.data.repository.HomeRepository
import com.yeonberry.flicks.core.data.repository.HomeRepositoryImpl
import com.yeonberry.flicks.core.data.repository.SearchRepository
import com.yeonberry.flicks.core.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

    @Binds
    @Singleton
    fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    fun bindFavoritesRepository(favoritesRepositoryImpl: FavoritesRepositoryImpl): FavoritesRepository

    @Binds
    @Singleton
    fun bindDetailsRepository(detailsRepositoryImpl: DetailsRepositoryImpl): DetailsRepository
}