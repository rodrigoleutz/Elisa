package br.com.uware.elisa.presentation.screen.games.rock_paper_scissors

import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random
import kotlin.random.nextInt

class RockPaperScissorsScreenState {

    val victoryText = mutableStateOf("Jogue")

    fun play(player: Int): Int {
        val comp = Random.nextInt(IntRange(1,3))
        victoryText.value = when {
            player == comp ->  "Empate"
            (player == 1 && comp == 2) || (player == 2 && comp == 3) || (player == 3 && comp == 1) -> "Perdeu"
            else -> "Ganhou"
        }
        return comp
    }
}