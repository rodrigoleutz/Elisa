package br.com.uware.elisa.presentation.screen.games.math

import br.com.uware.elisa.Res

object MathLevels {

    val easy = MathLevelModel(
        level = 1,
        name = Res.string.easy
    )

    val medium = MathLevelModel(
        level = 2,
        name = Res.string.medium
    )

    val hard = MathLevelModel(
        level = 3,
        name = Res.string.hard
    )

    val all = listOf<MathLevelModel>(easy, medium, hard)

}