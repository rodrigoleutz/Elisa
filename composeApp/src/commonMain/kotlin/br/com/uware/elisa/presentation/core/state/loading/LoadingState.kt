package br.com.uware.elisa.presentation.core.state.loading

import androidx.compose.runtime.State

interface LoadingState {
    val isLoading: State<Boolean>
    val status: State<LoadingStatus>
    val message: State<String>

    fun start()
    fun end()
    fun error(message: String)

    enum class LoadingStatus {
        Idle,
        Loading,
        Error
    }
}