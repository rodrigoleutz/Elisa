package br.com.uware.elisa.domain.use_case.games.math

import br.com.uware.elisa.domain.model.games.GameModel
import kotlin.random.Random
import kotlin.random.nextInt

class MathPlayHardUseCase {

    operator fun invoke(): GameModel {
        var first: Int? = null
        var second: Int? = null
        val operation = Random.nextInt(IntRange(1,4))
        var result = 0
        if(operation == 4) {
            do {
                first = Random.nextInt(IntRange(1,100))
                second = Random.nextInt(IntRange(1,100))
            } while (first != null && second != null && first % second != 0)
        } else {
            first = Random.nextInt(IntRange(1,100))
            second = Random.nextInt(IntRange(1,100))
        }
        result = MathOperationUseCase().invoke(first!!, second!!, operation)
        return GameModel(
            first,second, operation, result
        )
    }
}