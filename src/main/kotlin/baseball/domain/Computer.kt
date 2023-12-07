package baseball.domain

class Computer {

    private lateinit var computerNumbers: Numbers

    fun chooseNumbers() {
        computerNumbers = Numbers.createRandomNumbers()
    }

    fun matchNumbers(userNumbers: Numbers): MatchResult = computerNumbers.matchWith(userNumbers)
}