package br.com.uware.elisa.presentation.screen.games.tic_tac_toe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.theme.Dimension
import br.com.uware.elisa.presentation.theme.Font
import cafe.adriel.voyager.core.screen.Screen

class TicTacToeScreen : Screen {

    private val state = TicTacToeScreenState()

    @Composable
    override fun Content() {
        var player = remember {
            mutableStateOf(true)
        }
        val play = remember {
            mutableStateOf(1)
        }
        val buttonValues = (0..8).toList()
        var index = 0
        var checked = remember {
            state.list
        }
        val title = remember {
            mutableStateOf(Res.string.tic_tac_toe)
        }
        MainScreen { mainApp ->
            CenterColumnComponent {
                Text(
                    text = title.value,
                    fontSize = Font.giant
                )
                Column(
                    modifier = Modifier.fillMaxWidth().padding(Dimension.giant)
                ) {
                    for (row in 0..2) {
                        Row {
                            for (col in 0..2) {
                                val place = buttonValues[index]
                                OutlinedButton(
                                    onClick = {
                                        if (play.value < 10) {
                                            val newList = checked.value.toMutableList()
                                            newList[place] = if (player.value) 1 else 2
                                            checked.value = newList
                                            player.value = !player.value
                                            ++play.value
                                            if (state.checkVictory() == true || state.checkVictory() == false) {
                                                play.value = 10
                                            }
                                            title.value = when (state.checkVictory()) {
                                                true -> "X"
                                                false -> "O"
                                                else -> Res.string.tic_tac_toe
                                            }
                                        }
                                    },
                                    modifier = Modifier.weight(1f).height(100.dp),
                                    shape = RectangleShape,
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        containerColor = Color.White,
                                        contentColor = Color.Black
                                    ),
                                    border = ButtonDefaults.outlinedButtonBorder
                                ) {
                                    Text(
                                        when (checked.value[place]) {
                                            1 -> "X"
                                            2 -> "O"
                                            else -> ""
                                        }
                                    )
                                }
                                index++
                                if (index == 9) index = 8
                            }
                        }
                    }
                }
            }
        }
    }
}