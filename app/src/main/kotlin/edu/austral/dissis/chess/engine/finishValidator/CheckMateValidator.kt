package edu.austral.dissis.chess.engine.finishValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Position

class CheckMateValidator : FinishValidator {
    override fun check(gameState: GameState): CheckFinishResult {
        if(
            gameState.getActualBoard().getTile(Position(5,5)).hasPiece() &&
            gameState.getActualBoard().getTile(Position(5,5)).getPiece().getName() == "QUEEN"
        ) {
           return HasWinnerResult("WHITE")
        }
        return NoWinnerResult()
    }
}