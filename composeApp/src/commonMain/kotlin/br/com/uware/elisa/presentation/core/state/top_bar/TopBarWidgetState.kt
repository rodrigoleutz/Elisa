package br.com.uware.elisa.presentation.core.state.top_bar

import androidx.compose.runtime.State
import androidx.compose.ui.graphics.vector.ImageVector

interface TopBarWidgetState {
    val title: State<String>
    val navIcon: State<ImageVector>

    fun setTitle(value: String)
    fun setNavIcon(value: ImageVector)
}