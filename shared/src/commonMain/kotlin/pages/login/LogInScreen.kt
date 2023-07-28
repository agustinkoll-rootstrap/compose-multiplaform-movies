package pages.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import common.AppButton
import common.AppTextField
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import theme.Padding

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogInScreen(
    viewModel: LogInViewModel,
    navigateToHome: () -> Unit
) {
    val uiState by viewModel.uiStateFlow.collectAsState()
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = Padding.huge)
    ) {
        Icon(
            painter = painterResource("drawable/rootstrap_logo.xml"),
            contentDescription = null,
            tint = Color.White
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            AppTextField(
                value = uiState.email,
                onValueChange = { viewModel.onEmailChanged(it) },
                label = "Email",
                showError = uiState.showEmailError,
                errorMessage = "Email format not valid"
            )

            AppTextField(
                value = uiState.password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                label = "Password",
                showError = uiState.showPasswordError,
                errorMessage = "Password must contain a lower case, upper case, a number and a special character",
                isPasswordField = true
            )
        }

        AppButton(
            label = "Log in",
            enabled = uiState.isButtonEnabled
        ) {
            viewModel.onLogInButtonClicked()
            navigateToHome()
        }
    }
}

