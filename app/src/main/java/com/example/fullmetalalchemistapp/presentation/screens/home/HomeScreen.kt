package com.example.fullmetalalchemistapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.fullmetalalchemistapp.presentation.components.RatingWidget
import com.example.fullmetalalchemistapp.ui.theme.LARGE_PADDING
import com.example.fullmetalalchemistapp.ui.theme.Purple500

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) {
        it
        RatingWidget(
            rating = -10.0,
            starFilledColor = Purple500,
            modifier = Modifier
                .padding(LARGE_PADDING)
        )
    }

}