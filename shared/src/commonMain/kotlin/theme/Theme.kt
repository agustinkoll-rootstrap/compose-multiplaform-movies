package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_background
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_error
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_onBackground
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_onError
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_onPrimary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_onSecondary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_onSurface
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_onSurfaceVariant
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_primary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_secondary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_dark_surface
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_background
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_error
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_onBackground
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_onError
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_onPrimary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_onSecondary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_onSurface
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_primary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_secondary
import com.rootstrap.androidcomposebase.ui.theme.md_theme_light_surface

private val LightColors = Colors(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    secondaryVariant = md_theme_light_secondary,
    primaryVariant = md_theme_light_primary,
    isLight = false
)


private val DarkColors = Colors(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    primaryVariant = md_theme_dark_onSurfaceVariant,
    secondaryVariant = md_theme_dark_secondary,
    isLight = true
)

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    val shapes = Shapes(
        small = RoundedCornerShape(ShapeRadius.small),
        medium = RoundedCornerShape(ShapeRadius.medium),
        large = RoundedCornerShape(ShapeRadius.large),
    )

    MaterialTheme(
        colors = colors,
        content = content,
        typography = Typography,
        shapes = shapes,
    )
}