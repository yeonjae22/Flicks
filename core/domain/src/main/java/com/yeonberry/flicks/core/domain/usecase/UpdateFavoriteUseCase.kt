package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.flicks.core.data.repository.FavoritesRepository
import com.yeonberry.flicks.core.model.Movie
import javax.inject.Inject

class UpdateFavoriteUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {

    operator fun invoke(movie: Movie) {
        return if (movie.isFavorite) {
            repository.removeFavorite(movie)
        } else {
            repository.addFavorite(movie)
        }
    }
}