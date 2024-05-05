package com.yeonberry.flicks.core.data.di

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
}