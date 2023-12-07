package baseball

import baseball.controller.BaseballGameController
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val baseballGameController = BaseballGameController(InputView(), OutputView())
    baseballGameController.startGame()
}
