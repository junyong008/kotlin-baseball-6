package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputNumbers(): List<String> {
        print(INPUT_NUMBERS)
        return Console.readLine().map { it.toString() }
    }

    companion object {
        private const val INPUT_NUMBERS = "숫자를 입력해주세요 : "
    }
}