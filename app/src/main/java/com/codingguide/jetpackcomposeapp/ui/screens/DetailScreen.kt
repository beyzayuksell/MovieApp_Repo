package com.codingguide.jetpackcomposeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.material.Card
import androidx.compose.material.Divider
import com.codingguide.jetpackcomposeapp.model.Movie
import com.codingguide.jetpackcomposeapp.model.getMovies
import com.codingguide.jetpackcomposeapp.ui.components.MovieRow
import com.codingguide.jetpackcomposeapp.ui.components.TopBarApp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val newMovieList = getMovies().filter { movie -> movie.id == movieId  }
    Scaffold(
        topBar = {
            TopBarApp(title = "Movies", navController = navController, showBackButton = true)
        }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) { Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(
                    movie = newMovieList.first(),
                    clickAction = {/* Tıklama işlemi */ },
                    showDetails = true
                )
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Movie Images")
                HorizontalScrollableImageView(newMovieList)
            }
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp)
            ) {
                AsyncImage(
                    model = image,
                    modifier = Modifier.fillMaxHeight(),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}









