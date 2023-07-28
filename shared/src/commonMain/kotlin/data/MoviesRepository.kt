package data

import domain.movie.MovieResult
import domain.movie.MovieWrapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class MoviesRepository() {

    private val client = HttpClient {
        install(ContentNegotiation) { json() }
    }

    suspend fun fetchMovies(): List<MovieResult> {
        val key = "37b2654d338023c318312c90b5eee0ba"
        val response = client.get("https://api.themoviedb.org/3/discover/movie?api_key=$key")
        val body: MovieWrapper = response.body()
        return body.results
    }
}