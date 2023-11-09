package br.com.uware.elisa.presentation.core.state.top_bar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.uware.elisa.Res
import compose.icons.FeatherIcons
import compose.icons.feathericons.Menu

class TopBarWidgetStateImpl: TopBarWidgetState {

    private val _title: MutableState<String> = mutableStateOf(Res.string.app_name)
    override val title: State<String>
        get() = _title
    private val _navIcon: MutableState<ImageVector> = mutableStateOf(FeatherIcons.Menu)
    override val navIcon: State<ImageVector>
        get() = _navIcon

    override fun setTitle(value: String) {
        _title.value = value
    }

    override fun setNavIcon(value: ImageVector) {
        _navIcon.value = value
    }
}