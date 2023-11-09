package br.com.uware.elisa.presentation.core.main

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import br.com.uware.elisa.presentation.core.state.loading.LoadingState
import br.com.uware.elisa.presentation.core.state.top_bar.TopBarWidgetState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainApp(
    val drawerState: DrawerState,
    val currentRoute: Screen?
): KoinComponent {
    val loading by inject<LoadingState>()
    val topBar by inject<TopBarWidgetState>()


}

@Composable
fun rememberMainApp(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    currentRoute: Screen? = LocalNavigator.current?.lastItem
): MainApp = MainApp(
    drawerState = drawerState,
    currentRoute = currentRoute
)