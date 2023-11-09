package br.com.uware.elisa

import androidx.compose.runtime.Composable
import br.com.uware.elisa.di.presentation.stateModule
import br.com.uware.elisa.di.presentation.widgetModule
import br.com.uware.elisa.presentation.screen.splash.SplashScreen
import br.com.uware.elisa.presentation.theme.AppTheme
import cafe.adriel.voyager.navigator.Navigator
import org.koin.core.context.startKoin

@Composable
internal fun App() = AppTheme {
    startKoin {
        modules(
            stateModule,
            widgetModule
        )
    }
    Navigator(SplashScreen())
}