package com.yeonberry.flicks.core.data.repository

import com.yeonberry.flicks.core.datastore.DataStoreManager
import com.yeonberry.flicks.core.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val dataStore: DataStoreManager
) : FavoritesRepository {
    override fun getFavorites(): Flow<List<Movie>> {
        return dataStore.favorites
    }

    override suspend fun updateFavorites(movie: Movie) {
        return dataStore.updateFavorites(movie)
    }
}