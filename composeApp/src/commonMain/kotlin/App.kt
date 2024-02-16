import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    AppTheme {
        var activeTab by remember { mutableStateOf(Tabs.Home) }
        var showDialog by remember { mutableStateOf(false) }

        if (showDialog) {
            AlertDialog(
                title = { Text("Contact info") },
                text = { Text("Contact info could be here!") },
                confirmButton = { TextButton(onClick = { showDialog = false }) { Text("OK") } },
                onDismissRequest = { showDialog = false }
            )
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Cupertino Sample") },
                    actions = {
                        IconButton(onClick = { showDialog = true }) {
                            Icon(Icons.Filled.Email, contentDescription = null)
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = activeTab == Tabs.Home,
                        icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                        label = { Text("Home") },
                        onClick = { activeTab = Tabs.Home }
                    )
                    NavigationBarItem(
                        selected = activeTab == Tabs.About,
                        icon = { Icon(Icons.Filled.Info, contentDescription = null) },
                        label = { Text("Settings") },
                        onClick = { activeTab = Tabs.About }
                    )
                }
            }
        ) {
            when (activeTab) {
                Tabs.Home -> MainTab(Modifier.padding(it))
                Tabs.About -> AboutTab(Modifier.padding(it))
            }
        }
    }
}

enum class Tabs {
    Home, About
}