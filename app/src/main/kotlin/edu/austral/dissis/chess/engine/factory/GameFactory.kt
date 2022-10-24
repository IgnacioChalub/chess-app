package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.Game


interface GameFactory {
    fun create(): Game
}