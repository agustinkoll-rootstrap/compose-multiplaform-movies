package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import pages.home.HomeScreen
import pages.home.HomeViewModel
import pages.login.LogInScreen
import pages.login.LogInViewModel

@Composable
fun MainContent(newScreen: Screens) {
    var screenState by remember { mutableStateOf(newScreen) }

    when (screenState) {
        is Screens.Login ->
            LogInScreen(LogInViewModel()){
                screenState = Screens.Home
            }

        is Screens.Home ->
            HomeScreen(HomeViewModel())
    }
}