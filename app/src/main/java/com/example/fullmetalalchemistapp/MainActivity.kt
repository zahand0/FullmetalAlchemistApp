package com.example.fullmetalalchemistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fullmetalalchemistapp.ui.theme.FullmetalAlchemistAppTheme
import com.example.fullmetalalchemistapp.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {
    
    private lateinit var navController: NavHostController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FullmetalAlchemistAppTheme {

                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
