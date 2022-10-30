package com.example.fullmetalalchemistapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.example.fullmetalalchemistapp.presentation.screens.home.HomeScreen
import com.example.fullmetalalchemistapp.presentation.screens.search.SearchScreen
import com.example.fullmetalalchemistapp.presentation.screens.splash.SplashScreen
import com.example.fullmetalalchemistapp.presentation.screens.welcome.WelcomeScreen
import com.example.fullmetalalchemistapp.util.Constants.DETAILS_ARGUMENT_KEY
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalAnimationApi::class)
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
    }
}