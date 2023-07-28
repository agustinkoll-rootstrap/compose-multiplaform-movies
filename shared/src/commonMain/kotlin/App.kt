import androidx.compose.runtime.Composable
import navigation.MainContent
import navigation.Screens
import org.jetbrains.compose.resources.ExperimentalResourceApi
import pages.login.LogInScreen
import pages.login.LogInViewModel
import theme.AppTheme

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    /*MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }
        }
    }*/
    AppTheme {
        //LogInScreen(LogInViewModel()
        MainContent(Screens.Login)
    }
}


