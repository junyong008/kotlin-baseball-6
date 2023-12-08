package baseball.domain

import baseball.exception.GameStateException

enum class GameState(private val code: String) {
    START("1"),
    OVER("2");

    companion object {
        fun from(userInput: String) = requireNotNull(
            entries.find { it.code == userInput }
        ) { GameStateException.INVALID_INPUT.message }
    }
}