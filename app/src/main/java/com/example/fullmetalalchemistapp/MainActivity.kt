package com.example.fullmetalalchemistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import com.example.fullmetalalchemistapp.navigation.SetupNavGraph
import com.example.fullmetalalchemistapp.ui.theme.FullmetalAlchemistAppTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FullmetalAlchemistAppTheme {

                navController = rememberAnimatedNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
