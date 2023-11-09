package br.com.uware.elisa.presentation.core.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.uware.elisa.presentation.widget.drawer_menu.DrawerMenuWidget
import br.com.uware.elisa.presentation.widget.top_bar.TopBarWidget

@Composable
fun MainScreen(
    content: @Composable (mainApp: MainApp) -> Unit
) {
    val mainApp = rememberMainApp()

    ModalNavigationDrawer(
        drawerState = mainApp.drawerState,
        drawerContent = {
            DrawerMenuWidget(mainApp)
        }
    ) {
        Scaffold(
            topBar = {
                TopBarWidget(mainApp)
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            ) {
                content(mainApp)
            }
        }
    }
}