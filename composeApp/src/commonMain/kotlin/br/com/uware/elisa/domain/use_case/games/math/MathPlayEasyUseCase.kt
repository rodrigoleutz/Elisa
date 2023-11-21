package br.com.uware.elisa.domain.use_case.games.math

import br.com.uware.elisa.domain.model.games.GameModel
import kotlin.random.Random
import kotlin.random.nextInt

class MathPlayEasyUseCase {

    operator fun invoke(): GameModel {
        var first: Int? = null
        var second: Int? = null
        val operation = Random.nextInt(IntRange(1,2))
        if(operation == 2) {
            do {
                first = Random.nextInt(11)
                second = Random.nextInt(11)
            } while (first != null && second!= null && first < second)
        } else {
            first = Random.nextInt(11)
            second = Random.nextInt(11)
        }
        val result = MathOperationUseCase().invoke(first!!,second!!,operation)
        return GameModel(
            first,second, operation, result
        )
    }
}