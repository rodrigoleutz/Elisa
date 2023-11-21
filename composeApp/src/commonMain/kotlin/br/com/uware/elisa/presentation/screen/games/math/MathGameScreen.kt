package br.com.uware.elisa.presentation.screen.games.math

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import br.com.uware.elisa.Res
import br.com.uware.elisa.domain.model.games.GameModel
import br.com.uware.elisa.domain.use_case.games.math.MathPlayEasyUseCase
import br.com.uware.elisa.domain.use_case.games.math.MathPlayHardUseCase
import br.com.uware.elisa.domain.use_case.games.math.MathPlayMediumUseCase
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.theme.Dimension
import br.com.uware.elisa.presentation.theme.Font
import cafe.adriel.voyager.core.screen.Screen

class MathGameScreen(
    private val level: Int
) : Screen {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
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
                AnimatedVisibility(
                    visible = game.value?.result.toString() != "",
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    val background by transition.animateColor { state ->
                        if (state == EnterExitState.Visible) Color.Green else Color.Red
                    }
                    Text(
                        text = textResult.value,
                        fontSize = Font.giant,
                        color = background,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(Dimension.giant))
                Text(
                    text = "${game.value?.first}${operation.value}${game.value?.second}",
                    fontSize = Font.giant
                )
                Spacer(modifier = Modifier.height(Dimension.giant))
                OutlinedTextField(
                    value = result.value,
                    onValueChange = {
                        result.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                    label = {
                            Text(text = Res.string.result)
                    },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = Dimension.giant*2)
                )
                Spacer(modifier = Modifier.height(Dimension.giant))
                Row(
                    modifier = Modifier.fillMaxWidth().padding(Dimension.giant)
                ) {
                    Button(
                        onClick = {
                            textResult.value = if (result.value == game.value?.result.toString())
                                Res.string.got_it_right
                            else
                                Res.string.wrong
                        },
                        modifier = Modifier.weight(1f).padding(Dimension.giant)
                    ) {
                        Text(Res.string.result)
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
                        },
                        modifier = Modifier.weight(1f).padding(Dimension.giant)
                    ) {
                        Text(Res.string.restart)
                    }
                }
            }
        }
    }
}