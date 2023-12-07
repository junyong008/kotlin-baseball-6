package baseball.domain

import baseball.exception.NumbersException

data class Numbers(private val values: List<Number>) {
    init {
        require(values.size == SIZE_NUMBERS) { NumbersException.OUT_DIGIT.getDigit(SIZE_NUMBERS) }
    }

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

    companion object {

        private const val SIZE_NUMBERS = 3

        fun createRandomNumbers(): Numbers {
            val numbers = mutableListOf<Number>()
            while (numbers.size < SIZE_NUMBERS) {
                val randomNumber = Number.createRandomNumber()
                if (!numbers.contains(randomNumber)) numbers.add(randomNumber)
            }
            return Numbers(numbers)
        }
    }
}