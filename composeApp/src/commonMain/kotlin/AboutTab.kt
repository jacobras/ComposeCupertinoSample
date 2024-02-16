import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun AboutTab(modifier: Modifier) {
    Text(
        modifier = modifier.padding(16.dp),
        text = "This app was made using Compose Multiplatform"
    )
}