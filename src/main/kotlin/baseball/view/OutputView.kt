package baseball.view

class OutputView {
    fun outputGameStartMessage() = println(GAME_START_MESSAGE)

    fun outputMatchResult(matchResult: String) = println(matchResult)

    fun outputGameOverMessage(numberCount: Int) = println(GAME_OVER_MESSAGE.format(numberCount))

    companion object {
        private const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        private const val GAME_OVER_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }
}