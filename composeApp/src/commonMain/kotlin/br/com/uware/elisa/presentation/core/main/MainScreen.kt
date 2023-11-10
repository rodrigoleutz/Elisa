package br.com.uware.elisa.presentation.core.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import br.com.uware.elisa.presentation.core.menu.DrawerMenuGamesItems
import br.com.uware.elisa.presentation.core.menu.DrawerMenuItems
import br.com.uware.elisa.presentation.screen.games.GamesScreen
import br.com.uware.elisa.presentation.widget.drawer_menu.DrawerMenuWidget
import br.com.uware.elisa.presentation.widget.top_bar.TopBarWidget
import cafe.adriel.voyager.navigator.LocalNavigator

@Composable
fun MainScreen(
    content: @Composable (mainApp: MainApp) -> Unit
) {
    val mainApp = rememberMainApp()
    val currentRoute = LocalNavigator.current?.lastItem
    ModalNavigationDrawer(
        drawerState = mainApp.drawerState,
        drawerContent = {
            DrawerMenuWidget(
                mainApp,
                when (currentRoute) {
                    GamesScreen() -> DrawerMenuGamesItems()
                    else -> DrawerMenuItems()
                }
            )
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