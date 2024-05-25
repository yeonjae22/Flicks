package com.yeonberry.flicks.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.yeonberry.flicks.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    data object Home : Screen("home", R.string.home, Icons.Filled.Home)
    data object Search : Screen("search", R.string.search, Icons.Filled.Search)
    data object Favorites : Screen("search", R.string.favorites, Icons.Filled.Favorite)
}