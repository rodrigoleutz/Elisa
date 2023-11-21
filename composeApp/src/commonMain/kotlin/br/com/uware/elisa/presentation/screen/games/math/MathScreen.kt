package br.com.uware.elisa.presentation.screen.games.math

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import br.com.uware.elisa.presentation.core.main.MainScreen
import cafe.adriel.voyager.core.screen.Screen

class MathScreen : Screen {
    @Composable
    override fun Content() {
        MainScreen { mainApp ->
            LazyColumn {
                items(MathLevels.all) {item ->
                    MathCard(mainApp, item)
                }
            }
        }
    }
}