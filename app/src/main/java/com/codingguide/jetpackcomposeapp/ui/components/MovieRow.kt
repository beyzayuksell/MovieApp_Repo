package com.codingguide.jetpackcomposeapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.codingguide.jetpackcomposeapp.model.Movie

@Composable
fun MovieRow(movie: Movie, clickAction: (Movie) -> Unit, showDetails: Boolean = false) {
    Column(modifier = Modifier.clickable { clickAction(movie) }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Film afişi için Image composable'ı
            AsyncImage(
                model = movie.poster,
                contentDescription = "Movie Poster",
                modifier = Modifier.size(100.dp)
            )

            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.body2)
                Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.body2)
            }
        }

        // showDetails true ise, ek detayları göster
        if (showDetails) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Year: ${movie.year}", style = MaterialTheme.typography.body2)
                Text(text = "Genre: ${movie.genre}", style = MaterialTheme.typography.body2)
                Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.body2)
                Text(text = "Plot: ${movie.plot}", style = MaterialTheme.typography.body2)
            }
        }
    }
}
