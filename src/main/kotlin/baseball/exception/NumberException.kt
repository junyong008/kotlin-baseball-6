package baseball.exception

enum class NumberException(val message: String) {
    OUT_RANGE("[ERROR] 숫자의 범위는 %d이상 %d이하 여야 합니다."),
    NOT_INTEGER("[ERROR] Int 범위 내 숫자만 입력 가능합니다.");

    fun getRange(minRange: Int, maxRange: Int) = message.format(minRange, maxRange)
}