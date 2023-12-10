package baseball.domain

import org.assertj.core.api.Assertions
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

    @Test
    fun `문자열로 객체 생성 - 정상 입력`() {
        // given
        val input = listOf("1", "2", "3")
        // when & then
        assertDoesNotThrow { Numbers.from(input) }
    }

    @Test
    fun `문자열로 객체 생성 - 개수 초과 예외 처리`() {
        // given
        val input = listOf("1", "2", "3", "4")
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Numbers.from(input) }
            .withMessage("[ERROR] 숫자는 총 3자리의 수여야 합니다.")
    }

    @Test
    fun `문자열로 객체 생성 - 중복 숫자 예외 처리`() {
        // given
        val input = listOf("1", "2", "1")
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Numbers.from(input) }
            .withMessage("[ERROR] 중복된 숫자가 있습니다.")
    }
}