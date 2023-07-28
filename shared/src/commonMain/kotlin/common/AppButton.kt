package common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import theme.ShapeRadius

@Composable
fun AppButton(
    label: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(ShapeRadius.small),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Green,
            contentColor = Color.Black,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.DarkGray
        )
    ) {
        Text(label)
    }
}
