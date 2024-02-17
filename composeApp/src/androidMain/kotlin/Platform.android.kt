import android.os.Build
import io.github.alexzhirkevich.cupertino.adaptive.Theme

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun determineTheme(): Theme = Theme.Material3