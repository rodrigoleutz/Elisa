package br.com.uware.elisa.presentation.screen.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.screen.home.HomeScreen
import br.com.uware.elisa.presentation.theme.lightPink
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import io.github.skeptick.libres.compose.painterResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        val navigator = LocalNavigator.current
        var visible by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(true) {
            visible = true
            delay(3000)
            navigator?.replace(HomeScreen())
        }
        CenterColumnComponent(
            modifier = Modifier.background(lightPink)
        ) {
            Row {
                AnimatedVisibility(
                    visible = visible,
                    enter = slideInHorizontally(animationSpec = tween(1500)) {
                        -it * 1
                    }
                ) {
                    Image(
                        painter = painterResource(Res.image.elisa),
                        contentDescription = null
                    )
                }
                AnimatedVisibility(
                    visible = visible,
                    enter = slideInHorizontally(animationSpec = tween(1500)) {
                        it * 1
                    }
                ) {
                    Image(
                        painter = painterResource(Res.image.rleutz),
                        contentDescription = null
                    )
                }
            }
        }
    }
}