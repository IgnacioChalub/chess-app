package edu.austral.dissis.chess.engine.mover

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.OccupiedSquare
import edu.austral.dissis.chess.engine.board.Position
import edu.austral.dissis.chess.engine.movementValidator.MovementValidator
import edu.austral.dissis.chess.engine.piece.Piece

class ShortCastlingMover(
    override val validators: List<MovementValidator>,
) : Mover {

    override fun move(movement: Movement, gameState: GameState) {
        val oldFromTile = gameState.getActualBoard().getTile(movement.getFrom())
        val oldToTile = gameState.getActualBoard().getTile(movement.getTo())
        gameState.getActualBoard().putAt(movement.getTo(), OccupiedSquare(oldToTile.getColor(), oldFromTile.getPiece()))
        gameState.getActualBoard().putAt(movement.getFrom(), EmptySquare(oldFromTile.getColor()))

        val oldFromTileRook = gameState.getActualBoard().getTile(Position(movement.getFrom().getX() + 2, movement.getFrom().getY()))
        val oldToTileRook = gameState.getActualBoard().getTile(Position(movement.getTo().getX()-1, movement.getTo().getY()))
        gameState.getActualBoard().putAt(Position(movement.getTo().getX()-1, movement.getTo().getY()), OccupiedSquare(oldToTileRook.getColor(), oldFromTileRook.getPiece()))
        gameState.getActualBoard().putAt(Position(movement.getFrom().getX() + 2, movement.getFrom().getY()), EmptySquare(oldFromTileRook.getColor()))
    }

    override fun validMovement(movement: Movement, gameState: GameState): Boolean {
        return validators.all {it.validate(gameState, movement)}
    }

}