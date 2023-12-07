package baseball.view

class OutputView {
    fun outputGameStartMessage() = println(GAME_START_MESSAGE)

    fun outputMatchResult(matchResult: String) = println(matchResult)

    companion object {
        private const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
    }
}