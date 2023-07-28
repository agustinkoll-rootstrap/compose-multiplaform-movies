package pages.home

import data.MoviesRepository
import domain.movie.MovieResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel {

    private var _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
    private var repository: MoviesRepository = MoviesRepository()
    val uiStateFlow: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val uiState: HomeUiState
        get() = _uiState.value

    fun fetchMovies() {
        scope.launch {
            val characters = repository.fetchMovies()
            _uiState.value = uiState.copy(movies = characters)
        }
    }
}

data class HomeUiState(val movies:List<MovieResult> = emptyList())


