package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputNumbers(): List<String> {
        print(INPUT_NUMBERS)
        return Console.readLine().map { it.toString() }
    }

    fun inputRestartOrNot(): String {
        println(INPUT_RESTART_OR_NOT)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_NUMBERS = "숫자를 입력해주세요 : "
        private const val INPUT_RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}