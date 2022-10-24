package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import kotlin.math.abs

class DistanceMovementValidator(private val limit: Int) : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
       return (abs(movement.getTo().getX()-movement.getFrom().getY()) + abs(movement.getTo().getY()-movement.getFrom().getY())) <= limit
    }
}