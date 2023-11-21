package br.com.uware.elisa.presentation.screen.games.math

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class MathScreenState {
    private val _level: MutableState<Int> = mutableStateOf(1)
    val level: State<Int> = _level

    fun setLevel(value: Int) {
        _level.value = value
    }
}