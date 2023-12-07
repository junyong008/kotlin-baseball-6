package baseball.controller

import baseball.domain.Computer
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
    }
}