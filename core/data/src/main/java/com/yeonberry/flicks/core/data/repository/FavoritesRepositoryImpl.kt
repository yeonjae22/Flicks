package com.yeonberry.flicks.core.data.repository

import com.yeonberry.flicks.core.data.mapper.asEntity
import com.yeonberry.flicks.core.database.dao.FavoriteDao
import com.yeonberry.flicks.core.database.entity.MovieEntity
import com.yeonberry.flicks.core.database.entity.asExternalModel
import com.yeonberry.flicks.core.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoritesRepository {

    override fun getFavorites(): Flow<List<Movie>> {
        return favoriteDao.getFavorites().map { it.map(MovieEntity::asExternalModel) }
    }

    override fun addFavorite(movie: Movie) {
        return favoriteDao.insert(movie.asEntity())
    }

    override fun removeFavorite(movie: Movie) {
        return favoriteDao.delete(movie.asEntity())
    }
}