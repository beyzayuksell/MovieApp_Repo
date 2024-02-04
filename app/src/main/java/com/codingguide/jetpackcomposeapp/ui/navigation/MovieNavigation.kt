package com.codingguide.jetpackcomposeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.codingguide.jetpackcomposeapp.ui.screens.HomeScreen
import com.codingguide.jetpackcomposeapp.ui.screens.DetailsScreen

@Composable
fun  MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =  MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            // here we pass where this
            // should lead us to
            HomeScreen(navController)
        }
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie" ) {type = NavType.StringType})
        ) {
                backStackEntry->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}