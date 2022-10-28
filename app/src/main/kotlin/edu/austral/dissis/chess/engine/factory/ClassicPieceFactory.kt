package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.movementValidator.*
import edu.austral.dissis.chess.engine.mover.CastlingMover
import edu.austral.dissis.chess.engine.mover.ClassicMover
import edu.austral.dissis.chess.engine.mover.CoronationMover
import edu.austral.dissis.chess.engine.piece.Piece

class ClassicPieceFactory {
    fun pawn(id: String, color: String, startingSideX: Int): Piece {
        return Piece(id, "PAWN", color, listOf(
            CoronationMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(1),
                    EmptySquareValidator(),
                    OnlyForwardVerticalValidator(startingSideX),
                    CoronationSpecialValidator(startingSideX)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(1),
                    EmptySquareValidator(),
                    OnlyForwardVerticalValidator(startingSideX)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(2),
                    HasMovedValidator(),
                    EmptySquareValidator(),
                    OnlyForwardVerticalValidator(startingSideX)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalDistanceValidator(1),
                    EatsValidator(),
                    OnlyForwardVerticalValidator(startingSideX)
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
                    SpecialHorseMovementValidator(),
                    NotSameColorValidator()
                )
            ),
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
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalClearPathValidator()
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
                    HorizontalDistanceValidator(1)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(1)
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalDistanceValidator(1)
                )
            ),
            CastlingMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HasMovedValidator(),
                    HorizontalClearPathValidator(),
                    CastlingSpecialValidator()
                )
            )
        ))
    }
}