package br.com.uware.elisa.presentation.core.menu

import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.screen.games.tic_tac_toe.TicTacToeScreen
import compose.icons.FeatherIcons
import compose.icons.feathericons.Hash


class DrawerMenuGamesItems: DrawerMenu {

    val ticTacToe = MenuItem(
        id = 1,
        label = Res.string.tic_tac_toe,
        route = TicTacToeScreen(),
        icon = FeatherIcons.Hash,
        description = Res.string.tic_tac_toe_description
    )

    override val all: List<MenuItem>
        get() = listOf<MenuItem>(ticTacToe)

}