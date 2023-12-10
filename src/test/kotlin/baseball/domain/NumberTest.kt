package baseball.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 7, 9])
    fun `객체 생성 - 정상 입력`(input: Int) {
        // when & then
        assertDoesNotThrow { Number(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    fun `객체 생성 - 범위 초과 예외 처리`(input: Int) {
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Number(input) }
            .withMessage("[ERROR] 숫자의 범위는 1이상 9이하 여야 합니다.")
    }

    @Test
    fun `문자열로 객체 생성 - 정상 입력`() {
        // given
        val input = "7"
        // when
        val result = Number.from(input)
        // then
        assertEquals(Number(7), result)
    }

    @Test
    fun `문자열로 객체 생성 - 빈 값 입력 예외 처리`() {
        // given
        val input = ""
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Number.from(input) }
            .withMessage("[ERROR] Int 범위 내 숫자만 입력 가능합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abcd", "2147483648", "-2147483649"])
    fun `문자열로 객체 생성 - Int 범위 초과 입력 예외 처리`(input: String) {
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Number.from(input) }
            .withMessage("[ERROR] Int 범위 내 숫자만 입력 가능합니다.")
    }
}