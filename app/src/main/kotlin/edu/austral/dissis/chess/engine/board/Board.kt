package edu.austral.dissis.chess.engine.board

import edu.austral.dissis.chess.engine.piece.Piece


interface Board {
    fun getTile(position: Position): Tile
    fun putAt(position: Position, tile: Tile): Tile
    fun betweenLimits(position: Position): Boolean
    fun getCopy(): Board
    fun getPieces(): List<Piece>
    override fun toString(): String
    fun getPositionFromPiece(piece: Piece): Position
}