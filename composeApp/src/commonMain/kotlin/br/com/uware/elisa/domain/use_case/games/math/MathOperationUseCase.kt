package br.com.uware.elisa.domain.use_case.games.math

class MathOperationUseCase {
    operator fun invoke(first: Int, second: Int, operator: Int): Int {
        return when(operator) {
            1 -> first+second
            2 -> first-second
            3 -> first*second
            else -> first/second
        }
    }
}