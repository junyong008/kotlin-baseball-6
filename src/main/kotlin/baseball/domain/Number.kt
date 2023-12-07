package baseball.domain

import baseball.exception.NumberException
import camp.nextstep.edu.missionutils.Randoms

data class Number(private val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { NumberException.OUT_RANGE.getRange(MIN_NUMBER, MAX_NUMBER) }
    }

    companion object {

        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 9

        fun createRandomNumber(): Number {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            return Number(randomNumber)
        }
    }
}