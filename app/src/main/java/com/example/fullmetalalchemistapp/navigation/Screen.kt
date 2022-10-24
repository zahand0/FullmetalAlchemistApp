package com.example.fullmetalalchemistapp.navigation

import com.example.fullmetalalchemistapp.util.Constants.DETAILS_ARGUMENT_KEY

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Home: Screen("home_screen")
    object Search: Screen("home_screen")
    object Details: Screen("details_screen/{$DETAILS_ARGUMENT_KEY}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }
}
