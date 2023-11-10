package br.com.uware.elisa.presentation.widget.top_bar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.theme.lightPink
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWidget(
    mainApp: MainApp
) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(text = mainApp.topBar.title.value, fontWeight = FontWeight.Bold)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        mainApp.drawerState.open()
                    }
                }
            ) {
                Icon(imageVector = mainApp.topBar.navIcon.value, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = lightPink,
            navigationIconContentColor = Color.DarkGray,
            titleContentColor = Color.DarkGray,
            actionIconContentColor = Color.DarkGray
        )
    )
}