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
        val userNumbers = inputNumbers()
    }

    private fun inputNumbers(): Numbers {
        val input = inputView.inputNumbers()
        return Numbers.from(input)
    }
}