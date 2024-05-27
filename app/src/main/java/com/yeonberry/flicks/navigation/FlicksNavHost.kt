package com.yeonberry.flicks.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yeonberry.flicks.feature.home.HomeScreen
import com.yeonberry.flicks.feature.search.SearchScreen
import com.yeonberry.kakao.feature.favorites.FavoritesScreen

@Composable
fun FlicksNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = Screen.Home.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(Screen.Search.route) {
            SearchScreen(modifier = modifier)
        }
        composable(Screen.Favorites.route) {
            FavoritesScreen(modifier = modifier)
        }
    }
}