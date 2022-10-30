package com.example.fullmetalalchemistapp.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            SearchWidget(
                text = "",
                onTextChange = {},
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }
    ) {

    }
}