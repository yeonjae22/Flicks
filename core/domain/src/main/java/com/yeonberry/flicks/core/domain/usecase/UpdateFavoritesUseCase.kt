package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.flicks.core.data.repository.FavoritesRepository
import com.yeonberry.flicks.core.model.Movie
import javax.inject.Inject

class UpdateFavoritesUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {

    suspend operator fun invoke(favorites: List<Movie>) = repository.updateFavorites(favorites)
}