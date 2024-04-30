import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

// Quedo sin uso
@Composable fun MainView() = App()

@RequiresApi(Build.VERSION_CODES.O)
actual fun getFormattedDate(
    iso8601Timestamp: String,
    format: String,
): String {
    val date = getDateFromIso8601Timestamp(iso8601Timestamp)
    val formatter = DateTimeFormatter.ofPattern(format)
    return date.format(formatter) + " Android"
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getDateFromIso8601Timestamp(string: String): ZonedDateTime {
    return ZonedDateTime.parse(string)
}