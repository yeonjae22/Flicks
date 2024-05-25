package com.yeonberry.flicks.navigation

import androidx.annotation.StringRes
import com.yeonberry.flicks.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object Home : Screen("home", R.string.home)
    data object Search : Screen("search", R.string.search)
}