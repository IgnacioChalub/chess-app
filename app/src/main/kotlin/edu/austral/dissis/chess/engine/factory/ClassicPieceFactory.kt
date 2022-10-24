package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.movementValidator.*
import edu.austral.dissis.chess.engine.mover.ClassicMover
import edu.austral.dissis.chess.engine.mover.ShortCastlingMover
import edu.austral.dissis.chess.engine.piece.Piece

class ClassicPieceFactory {
    fun pawn(id: String, color: String): Piece {
        return Piece(id, "PAWN", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    DistanceMovementValidator(1),
                    EmptySquareValidator()
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    DistanceMovementValidator(2),
                    HasMovedValidator(),
                    EmptySquareValidator()
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DistanceMovementValidator(1),
                    EatsValidator()
                )
            ),
        ))
    }
    fun bishop(id: String, color: String): Piece {
        return Piece(id, "BISHOP", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalClearPathValidator()
                )
            )
        ))
    }
    fun knight(id: String, color: String): Piece {
        return Piece(id, "KNIGHT", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                )
            ),
            ShortCastlingMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
//                    ClearPathMovementValidator(),
                    HasMovedValidator()
                )
            )
        ))
    }
    fun rook(id: String, color: String): Piece {
        return Piece(id, "ROOK", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    HorizontalClearPathValidator()
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalClearPathValidator()
                )
            ),
        ))
    }
    fun queen(id: String, color: String): Piece {
        return Piece(id, "QUEEN", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                )
            ),
        ))
    }
    fun king(id: String, color: String): Piece {
        return Piece(id,"KING", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    DistanceMovementValidator(1)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    DistanceMovementValidator(1)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DistanceMovementValidator(1)
                )
            ),
        ))
    }
}