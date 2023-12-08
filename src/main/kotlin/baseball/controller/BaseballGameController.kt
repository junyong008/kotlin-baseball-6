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

    fun startGame() {
        outputView.outputGameStartMessage()
        gameState = GameState.START

        while (gameState == GameState.START) {
            computer.chooseNumbers()
            while (gameState == GameState.START) {
                val userNumbers = inputNumbers()
                val matchResult = computer.matchNumbers(userNumbers)
                outputView.outputMatchResult(matchResult.toString())
                if (matchResult.isAllStrike()) break
            }
            outputView.outputGameOverMessage(Numbers.SIZE_NUMBERS)
            gameState = GameState.from(inputIsRestart())
        }
    }

    private fun inputNumbers(): Numbers {
        val input = inputView.inputNumbers()
        return Numbers.from(input)
    }

    private fun inputIsRestart(): String = inputView.inputRestartOrNot()
}