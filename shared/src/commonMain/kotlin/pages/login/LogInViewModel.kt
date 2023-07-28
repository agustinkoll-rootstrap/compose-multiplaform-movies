package pages.login

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LogInViewModel {

    private var _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    val uiStateFlow: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val uiState: LoginUiState
        get() = _uiState.value

    fun onEmailChanged(email: String) {
        val isEmailValid = email.isNotEmpty()
        _uiState.update { uiState.copy(email = email, showEmailError = !isEmailValid) }
    }

    fun onPasswordChanged(password: String) {
        val isPasswordValid = password.isNotEmpty()
        _uiState.update { uiState.copy(password = password, showPasswordError = !isPasswordValid) }
    }

    fun onLogInButtonClicked() {
        scope.launch {
            // Code inside the coroutine
            delay(1000L)

        }
    }
}
