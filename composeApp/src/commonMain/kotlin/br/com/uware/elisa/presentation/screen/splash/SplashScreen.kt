package br.com.uware.elisa.presentation.screen.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.screen.home.HomeScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.delay

class SplashScreen: Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        LaunchedEffect(true) {
            delay(2000)
            navigator?.replace(HomeScreen())
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${Res.string.app_name} Splash Screen")
        }
    }
}