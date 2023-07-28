package pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import domain.movie.MovieResult
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val uiState by homeViewModel.uiStateFlow.collectAsState()
    LaunchedEffect(true) {
        homeViewModel.fetchMovies()
    }
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "My Movies") },
            backgroundColor = Color.Blue,
            contentColor = Color.White
        )
    })
    {
        Box(modifier = Modifier.background(Color.Black).fillMaxSize())
        HomeScreenList(uiState)
    }
}

@Composable
fun HomeScreenList(homeUiState: HomeUiState) {
    LazyColumn(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        val list = homeUiState.movies
        items(list.size) {
            MovieCard(list[it])
        }
    }
}

@Composable
fun MovieCard(character: MovieResult) {
    val key = "37b2654d338023c318312c90b5eee0ba"
    Card(
        modifier = Modifier
            .background(Color.Black.copy(alpha = 0.9f))
            .fillMaxWidth()
            .height(180.dp)
            .padding(8.dp),
        elevation = 8.dp
    ) {
        Row {
            // Image
            val url = "https://image.tmdb.org/t/p/w500" + character.poster_path + "?api_key=$key"
            val resource =
                asyncPainterResource(data = url)
            KamelImage(
                resource = resource,
                contentDescription = "",
                modifier = Modifier.fillMaxHeight().width(100.dp),
                contentScale = ContentScale.FillBounds
            )
            Column {
                // Name
                Text(
                    text = character.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp),
                    color = Color.White
                )

                Text(
                    text = "Overview:",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = Color.White
                )

                Text(
                    text = character.overview,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = Color.White,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}