package com.yeonberry.flicks.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeonberry.flicks.feature.home.HomeScreen
import com.yeonberry.flicks.feature.search.SearchScreen

@Composable
fun FlicksNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "search_route"
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home_route") {
            HomeScreen()
        }
        composable("search_route") {
            SearchScreen(
                onBackClick = navController::popBackStack
            )
        }
    }
}