import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import io.ktor.util.Digest
import io.ktor.util.hex
import io.ktor.utils.io.core.toByteArray
import java.security.MessageDigest
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable fun MainView() = App()

@RequiresApi(Build.VERSION_CODES.O)
actual fun getFormattedDate(
    iso8601Timestamp: String,
    format: String,
): String {
    val date = getDateFromIso8601Timestamp(iso8601Timestamp)
    val formatter = DateTimeFormatter.ofPattern(format)
    return date.format(formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getDateFromIso8601Timestamp(string: String): ZonedDateTime {
    return ZonedDateTime.parse(string)
}