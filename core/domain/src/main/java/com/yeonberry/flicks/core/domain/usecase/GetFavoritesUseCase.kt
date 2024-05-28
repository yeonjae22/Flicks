package com.yeonberry.flicks.core.domain.usecase

import com.yeonberry.flicks.core.data.repository.FavoritesRepository
import com.yeonberry.flicks.core.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {

    operator fun invoke(): Flow<List<Movie>> = repository.getFavorites()
}