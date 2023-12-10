package baseball.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MatchResultTest {
    @Test
    fun `결과가 모두 스트라이크인지 확인`() {
        // given
        val input = MatchResult(3, 0, 0)
        // when
        val result = input.isAllStrike()
        // then
        assertEquals(true, result)
    }
}