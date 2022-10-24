package edu.austral.dissis.chess.engine.board

import edu.austral.dissis.chess.engine.piece.Piece
import java.lang.Error
import java.lang.Exception

class EmptySquare(private val color: String) : Tile {
    override fun hasPiece(): Boolean = false
    override fun getPiece(): Piece = throw Error()
    override fun toString(): String = " [Empty ${color[0]}] "
    override fun getColor() = color
}