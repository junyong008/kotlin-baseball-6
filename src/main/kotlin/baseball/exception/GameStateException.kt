package baseball.exception

enum class GameStateException(val message: String) {
    INVALID_INPUT("[ERROR] 1 혹은 2만 입력 가능합니다.")
}