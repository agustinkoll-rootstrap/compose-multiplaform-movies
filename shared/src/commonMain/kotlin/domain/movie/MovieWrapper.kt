package domain.movie

import kotlinx.serialization.Serializable

@Serializable
data class MovieWrapper(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)