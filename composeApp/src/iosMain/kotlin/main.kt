import androidx.compose.ui.window.ComposeUIViewController
import br.com.uware.elisa.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
