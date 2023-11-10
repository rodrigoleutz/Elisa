package br.com.uware.elisa.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.component.card.CardComponent
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.screen.games.GamesScreen
import br.com.uware.elisa.presentation.screen.games.tic_tac_toe.TicTacToeScreen
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.regular.ClosedCaptioning
import compose.icons.fontawesomeicons.regular.PaperPlane

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        MainScreen { mainApp ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardComponent(
                    label = Res.string.games,
                    icon = FontAwesomeIcons.Regular.PaperPlane,
                    route = GamesScreen()
                )
            }
        }
    }
}