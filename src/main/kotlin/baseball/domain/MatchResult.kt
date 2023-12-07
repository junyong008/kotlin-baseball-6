package baseball.domain

data class MatchResult(
    private val strike: Int,
    private val ball: Int,
    private val nothing: Int,
) {
    fun isAllStrike(): Boolean = ball < 1 && nothing < 1

    override fun toString(): String = when {
        strike > 0 && ball > 0 -> "${ball}볼 ${strike}스트라이크"
        strike > 0 -> "${strike}스트라이크"
        ball > 0 -> "${ball}볼"
        else -> "낫싱"
    }
}