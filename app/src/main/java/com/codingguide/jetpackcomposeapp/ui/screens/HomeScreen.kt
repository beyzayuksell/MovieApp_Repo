package com.codingguide.jetpackcomposeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codingguide.jetpackcomposeapp.model.Movie
import com.codingguide.jetpackcomposeapp.model.getMovies
import com.codingguide.jetpackcomposeapp.ui.components.MovieRow
import com.codingguide.jetpackcomposeapp.ui.components.TopBarApp
import com.codingguide.jetpackcomposeapp.ui.navigation.MovieScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarApp(title = "Movies")
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it, clickAction = { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/${movie.id}")
                }, showDetails = false)  // Film detaylarının görüntülenmesini belirleme.
            }
        }
    }
}