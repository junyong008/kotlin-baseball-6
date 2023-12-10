package baseball.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameStateTest {
    @Test
    fun `사용자 입력으로 게임 상태 결정 - 정상 입력`() {
        // given
        val input = "1"
        // when
        val result = GameState.from(input)
        // then
        assertEquals(GameState.START, result)
    }

    @Test
    fun `사용자 입력으로 게임 상태 결정 - 존재하지 않는 값 입력`() {
        // given
        val input = "3"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { GameState.from(input) }
            .withMessage("[ERROR] 1 혹은 2만 입력 가능합니다.")
    }
}