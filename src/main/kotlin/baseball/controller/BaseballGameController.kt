package baseball.controller

import baseball.domain.Computer
import baseball.domain.Numbers
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    private val computer = Computer()

    fun startGame() {
        outputView.outputGameStartMessage()
        computer.chooseNumbers()
        while (true) {
            val userNumbers = inputNumbers()
            val matchResult = computer.matchNumbers(userNumbers)
            outputView.outputMatchResult(matchResult.toString())
            if (matchResult.isAllStrike()) break
        }
        outputView.outputGameOverMessage(Numbers.SIZE_NUMBERS)
    }

    private fun inputNumbers(): Numbers {
        val input = inputView.inputNumbers()
        return Numbers.from(input)
    }
}