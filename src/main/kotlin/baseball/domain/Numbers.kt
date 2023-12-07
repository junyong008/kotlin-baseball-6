package baseball.domain

data class Numbers(private val values: List<Number>) {
    fun matchWith(otherNumbers: Numbers): MatchResult {
        var strike = 0
        var ball = 0
        var nothing = 0
        values.forEachIndexed { i, number ->
            when (number) {
                otherNumbers.values[i] -> strike++
                in otherNumbers.values -> ball++
                else -> nothing++
            }
        }
        return MatchResult(strike, ball, nothing)
    }
}