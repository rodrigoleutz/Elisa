package br.com.uware.elisa.presentation.screen.games.math

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.uware.elisa.domain.model.games.GameModel
import br.com.uware.elisa.domain.use_case.games.math.MathPlayEasyUseCase
import br.com.uware.elisa.domain.use_case.games.math.MathPlayHardUseCase
import br.com.uware.elisa.domain.use_case.games.math.MathPlayMediumUseCase
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.theme.Dimension
import cafe.adriel.voyager.core.screen.Screen

class MathGameScreen(
    private val level: Int
) : Screen {

    @Composable
    override fun Content() {
        val game = remember {
            mutableStateOf<GameModel?>(null)
        }
        val operation = remember {
            mutableStateOf("")
        }
        val result = remember {
            mutableStateOf("")
        }
        val textResult = remember {
            mutableStateOf("")
        }
        MainScreen { mainApp ->
            LaunchedEffect(true) {
                game.value = when (level) {
                    1 -> MathPlayEasyUseCase().invoke()
                    2 -> MathPlayMediumUseCase().invoke()
                    else -> MathPlayHardUseCase().invoke()
                }
                operation.value = when (game.value?.operation) {
                    1 -> "+"
                    2 -> "-"
                    3 -> "*"
                    else -> "/"
                }
            }
            CenterColumnComponent {
                Text(textResult.value)
                Text("${game.value?.first}${operation.value}${game.value?.second}")
                TextField(
                    value = result.value,
                    onValueChange = {
                        result.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                Row {
                    Button(
                        onClick = {
                            textResult.value = if (result.value == game.value?.result.toString())
                                "Acertou"
                            else
                                "Errou"
                        }
                    ) {
                        Text("Resultado")
                    }
                    Spacer(modifier = Modifier.width(Dimension.medium))
                    Button(
                        onClick = {
                            textResult.value = ""
                            result.value = ""
                            game.value = when (level) {
                                1 -> MathPlayEasyUseCase().invoke()
                                2 -> MathPlayMediumUseCase().invoke()
                                else -> MathPlayHardUseCase().invoke()
                            }
                            operation.value = when (game.value?.operation) {
                                1 -> "+"
                                2 -> "-"
                                3 -> "*"
                                else -> "/"
                            }
                        }
                    ) {
                        Text("Reiniciar")
                    }
                }
            }
        }
    }
}