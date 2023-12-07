package baseball.controller

import baseball.view.InputView
import baseball.view.OutputView

class BaseballGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun startGame() {
        outputView.outputGameStartMessage()
    }
}