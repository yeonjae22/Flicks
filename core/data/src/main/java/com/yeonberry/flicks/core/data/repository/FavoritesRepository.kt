package com.yeonberry.flicks.core.data.repository

import com.yeonberry.flicks.core.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavorites(): Flow<List<Movie>>
    suspend fun updateFavorites(favorites: List<Movie>)
}