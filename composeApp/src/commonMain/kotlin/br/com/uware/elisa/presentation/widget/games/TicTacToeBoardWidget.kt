package br.com.uware.elisa.presentation.widget.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import br.com.uware.elisa.presentation.theme.Dimension
import co.touchlab.kermit.Logger

@Composable
fun TicTacToeBoardWidget(
    checkedValue: MutableState<ArrayList<Int>>,
    onClick: (Int) -> Unit
) {
    val buttonValues = (0..8).toList()
    var index = 0
    val checked = remember {
        checkedValue
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(Dimension.giant)
    ) {
        for (row in 0..2) {
            Row {
                for (col in 0..2) {
                    val place = buttonValues[index]
                    OutlinedButton(
                        onClick = {
                            onClick(place)
                            Logger.e(place.toString())
                            Logger.e(checked.value.toString())
                            Logger.e(checkedValue.value.toString())
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
                }
            }
        }
    }
}