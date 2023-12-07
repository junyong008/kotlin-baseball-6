package baseball.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `숫자끼리 비교하여 스트라이크, 볼 등 매칭 결과 계산`() {
        // given
        val computerNumbers = Numbers(
            listOf(Number(1), Number(2), Number(3))
        )
        val userNumbers = Numbers(
            listOf(Number(1), Number(3), Number(4))
        )
        // when
        val result = computerNumbers.matchWith(userNumbers)
        // then
        assertEquals(MatchResult(1, 1, 1), result)
    }
}