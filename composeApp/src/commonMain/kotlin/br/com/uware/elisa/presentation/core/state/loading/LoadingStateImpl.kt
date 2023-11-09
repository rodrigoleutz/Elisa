package br.com.uware.elisa.presentation.core.state.loading

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class LoadingStateImpl : LoadingState {
    private val _isLoading: MutableState<Boolean> =
        mutableStateOf(status.value == LoadingState.LoadingStatus.Loading)
    override val isLoading: State<Boolean>
        get() = _isLoading
    private val _status: MutableState<LoadingState.LoadingStatus> =
        mutableStateOf(LoadingState.LoadingStatus.Idle)
    override val status: State<LoadingState.LoadingStatus>
        get() = _status
    private val _message: MutableState<String> = mutableStateOf("")
    override val message: State<String>
        get() = _message

    override fun start() {
        _message.value = ""
        _status.value = LoadingState.LoadingStatus.Loading
    }

    override fun end() {
        _status.value = LoadingState.LoadingStatus.Idle
    }

    override fun error(message: String) {
        _message.value = message
        _status.value = LoadingState.LoadingStatus.Error
    }
}