import br.com.uware.elisa.presentation.screen.games.rock_paper_scissors.RockPaperScissorsScreenState
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class TestGames {

    @Test
    fun `RockPaperScissors`() {
        val state = RockPaperScissorsScreenState()
        for(x in 1..100) {
            val player = Random.nextInt(4)
            val comp = state.play(player)
            assertContains(listOf(1,2,3), comp)
        }
    }
}