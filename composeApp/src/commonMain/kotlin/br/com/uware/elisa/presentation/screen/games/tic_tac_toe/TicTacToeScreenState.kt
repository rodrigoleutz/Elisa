package br.com.uware.elisa.presentation.screen.games.tic_tac_toe

import androidx.compose.runtime.mutableStateOf

class TicTacToeScreenState {

    val list = mutableStateOf(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0))

    fun checkVictory(): Boolean? {
        val checkList = list.value.toMutableList()
        for (x in listOf<Int>(0, 3, 6)) {
            if (checkList[x] != 0 && checkList[x] == checkList[x + 1] && checkList[x + 1] == checkList[x + 2]) {
                return checkList[x] == 1
            }
        }
        for (x in listOf<Int>(0, 1, 2)) {
            if (checkList[x] != 0 && checkList[x] == checkList[x + 3] && checkList[x + 3] == checkList[x + 6]) {
                return checkList[x] == 1
            }
        }
        var x = 0
        if (checkList[x] != 0 && checkList[x] == checkList[x + 4] && checkList[x + 4] == checkList[x + 8]) {
            return checkList[x] == 1
        }
        x = 3
        if (checkList[x] != 0 && checkList[x] == checkList[x + 2] && checkList[x + 2] == checkList[x + 6]) {
            return checkList[x] == 1
        }
        return null
    }
}