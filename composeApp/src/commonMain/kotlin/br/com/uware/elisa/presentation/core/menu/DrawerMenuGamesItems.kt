package br.com.uware.elisa.presentation.core.menu

import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.screen.games.math.MathScreen
import br.com.uware.elisa.presentation.screen.games.rock_paper_scissors.RockPaperScissorsScreen
import br.com.uware.elisa.presentation.screen.games.tic_tac_toe.TicTacToeScreen
import compose.icons.FeatherIcons
import compose.icons.FontAwesomeIcons
import compose.icons.feathericons.Hash
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.brands.Android
import compose.icons.fontawesomeicons.regular.HandPeace


class DrawerMenuGamesItems: DrawerMenu {

    val ticTacToe = MenuItem(
        id = 1,
        label = Res.string.tic_tac_toe,
        route = TicTacToeScreen(),
        icon = FeatherIcons.Hash,
        description = Res.string.tic_tac_toe_description
    )

    val rockPaperScissors = MenuItem(
        id = 2,
        label = Res.string.rock_paper_scissors,
        route = RockPaperScissorsScreen(),
        icon = FontAwesomeIcons.Regular.HandPeace,
        description = Res.string.rock_paper_scissors_description
    )

    val math = MenuItem(
        id = 3,
        label = Res.string.math,
        route = MathScreen(),
        icon = FontAwesomeIcons.Brands.Android,
        description = Res.string.math_description
    )

    override val all: List<MenuItem>
        get() = listOf<MenuItem>(ticTacToe, rockPaperScissors, math)

}