package edu.austral.dissis.chess.engine.finishValidator

import java.lang.Error
import java.lang.Exception

class NoWinnerResult : CheckFinishResult{

    override fun hasWinner(): Boolean = false

    override fun getWinnerColor(): String = throw Exception()

}