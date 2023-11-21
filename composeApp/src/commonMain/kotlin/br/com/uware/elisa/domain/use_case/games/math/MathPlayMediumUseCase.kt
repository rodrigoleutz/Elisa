package br.com.uware.elisa.domain.use_case.games.math

import br.com.uware.elisa.domain.model.games.GameModel
import kotlin.random.Random
import kotlin.random.nextInt

class MathPlayMediumUseCase {

    operator fun invoke(): GameModel {
        val first = Random.nextInt(11)
        val second = Random.nextInt(11)
        val operation = Random.nextInt(IntRange(1,3))
        val result = MathOperationUseCase().invoke(first,second,operation)
        return GameModel(
            first,second, operation, result
        )
    }
}