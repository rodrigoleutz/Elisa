package br.com.uware.elisa.presentation.core.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Games
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.RoundaboutRight
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.screen.about.AboutScreen
import br.com.uware.elisa.presentation.screen.games.GamesScreen
import br.com.uware.elisa.presentation.screen.home.HomeScreen

class DrawerMenuItems: DrawerMenu {

    val home = MenuItem(
        id = 1,
        label = Res.string.home,
        route = HomeScreen(),
        icon = Icons.Rounded.Home,
        description = Res.string.home_description,
        inHome = false
    )

    val games = MenuItem(
        id = 2,
        label = Res.string.games,
        route = GamesScreen(),
        icon = Icons.Rounded.Games,
        description = Res.string.games_description
    )

    val about = MenuItem(
        id = 3,
        label = Res.string.about,
        route = AboutScreen(),
        icon = Icons.Rounded.Explore,
        description = Res.string.about_description
    )

    override val all: List<MenuItem>
        get() = listOf<MenuItem>(home, games, about)

}