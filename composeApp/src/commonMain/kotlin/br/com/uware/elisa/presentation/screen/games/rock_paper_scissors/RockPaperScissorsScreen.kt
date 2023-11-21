package br.com.uware.elisa.presentation.screen.games.rock_paper_scissors

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.theme.Dimension
import br.com.uware.elisa.presentation.theme.Font
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.regular.HandPaper
import compose.icons.fontawesomeicons.regular.HandRock
import compose.icons.fontawesomeicons.regular.HandScissors

class RockPaperScissorsScreen : Screen {

    private val state: RockPaperScissorsScreenState = RockPaperScissorsScreenState()

    private fun checkImage(value: Int): ImageVector {
        return when (value) {
            1 -> FontAwesomeIcons.Regular.HandRock
            2 -> FontAwesomeIcons.Regular.HandPaper
            else -> FontAwesomeIcons.Regular.HandScissors
        }
    }

    @Composable
    override fun Content() {
        val victoryText = remember {
            state.victoryText
        }
        val computerImage = remember {
            mutableStateOf<ImageVector?>(null)
        }
        val points = remember {
            state.points
        }
        MainScreen { mainApp ->
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier.align(Alignment.TopStart).padding(Dimension.medium)
                ) {
                    Text(
                        text = "${Res.string.points}: ",
                    )
                    Text(
                        text = "${points.value}",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().align(Alignment.Center)
                ) {
                    AnimatedVisibility(computerImage.value != null) {
                        Icon(
                            imageVector = computerImage.value!!,
                            contentDescription = null,
                            modifier = Modifier.padding(Dimension.giant)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
                        .padding(top = Dimension.big)
                ) {
                    Text(
                        text = victoryText.value,
                        fontSize = Font.giant,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                ) {
                    IconButton(
                        onClick = {
                            val result = state.play(1)
                            computerImage.value = checkImage(result)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Regular.HandRock,
                            contentDescription = Res.string.rock
                        )
                    }
                    IconButton(
                        onClick = {
                            val result = state.play(2)
                            computerImage.value = checkImage(result)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Regular.HandPaper,
                            contentDescription = Res.string.paper
                        )
                    }
                    IconButton(
                        onClick = {
                            val result = state.play(3)
                            computerImage.value = checkImage(result)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Regular.HandScissors,
                            contentDescription = Res.string.scissors
                        )
                    }
                }
            }
        }
    }
}