package baseball.exception

enum class NumbersException(val message: String) {
    OUT_DIGIT("[ERROR] 숫자는 총 %d자리의 수여야 합니다.");

    fun getDigit(digit: Int) = message.format(digit)
}