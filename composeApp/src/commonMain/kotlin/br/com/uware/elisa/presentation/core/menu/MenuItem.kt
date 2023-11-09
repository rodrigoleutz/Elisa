package br.com.uware.elisa.presentation.core.menu

import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen

data class MenuItem(
    val id: Int,
    val label: String,
    val route: Screen,
    val icon: ImageVector,
    val description: String
)
