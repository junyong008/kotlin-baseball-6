package baseball.controller

import baseball.domain.Computer
import baseball.domain.GameState
import baseball.domain.Numbers
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    private val computer = Computer()
    private var gameState = GameState.OVER

    fun run() {
        outputView.outputGameStartMessage()
        gameState = GameState.START

        while (gameState == GameState.START) playGame()
    }

    private fun playGame() {
        computer.chooseNumbers()
        while (gameState == GameState.START) matchNumbers()
        outputView.outputGameOverMessage(Numbers.SIZE_NUMBERS)
        gameState = GameState.from(inputIsRestart())
    }

    private fun matchNumbers() {
        val matchResult = computer.matchNumbers(inputNumbers())
        outputView.outputMatchResult(matchResult.toString())
        if (matchResult.isAllStrike()) gameState = GameState.OVER
    }

    private fun inputNumbers(): Numbers {
        val input = inputView.inputNumbers()
        return Numbers.from(input)
    }

    private fun inputIsRestart(): String = inputView.inputRestartOrNot()
}