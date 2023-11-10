package br.com.uware.elisa.presentation.screen.games

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.screen.games.rock_paper_scissors.RockPaperScissorsScreen
import br.com.uware.elisa.presentation.screen.games.tic_tac_toe.TicTacToeScreen
import br.com.uware.elisa.presentation.theme.Dimension
import br.com.uware.elisa.presentation.theme.Font
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class GamesScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        val navigator = LocalNavigator.current
        MainScreen { mainApp: MainApp ->
            CenterColumnComponent {
                Card(
                    onClick = {
                        navigator?.push(TicTacToeScreen())
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = Res.string.tic_tac_toe,
                        modifier = Modifier.padding(Dimension.medium),
                        fontSize = Font.big,
                        textAlign = TextAlign.Center
                    )
                }
                Card(
                    onClick = {
                        navigator?.push(RockPaperScissorsScreen())
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = Res.string.rock_paper_scissors,
                        modifier = Modifier.padding(Dimension.medium),
                        fontSize = Font.big
                    )
                }
            }
        }
    }
}