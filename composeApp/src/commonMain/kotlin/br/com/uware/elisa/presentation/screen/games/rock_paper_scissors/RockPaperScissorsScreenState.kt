package br.com.uware.elisa.presentation.screen.games.rock_paper_scissors

import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random

class RockPaperScissorsScreenState {

    val victoryText = mutableStateOf("Jogue")

    fun play(player: Int): Int {
        val comp = Random.nextInt(4)
        victoryText.value = when {
            player == comp ->  "Empate"
            (player == 1 && comp == 2) || (player == 2 && comp == 3) || (player == 3 && comp == 1) -> "Perdeu"
            else -> "Ganhou"
        }
        return comp
    }
}