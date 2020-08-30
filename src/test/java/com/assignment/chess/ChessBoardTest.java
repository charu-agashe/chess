package com.assignment.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    void testSetAndGetPieceAtCoordinate() {
        ChessBoard board = new ChessBoard();
        Rook rook = new Rook("R","W",board,"a1" );
        rook.setCoordinates(1,1);
        board.setPieceAtCoordinates(rook,1,1);
        Piece pieceAtCoordinate = board.getPieceAtCoordinate(1, 1);

        assertEquals(rook.getName(),pieceAtCoordinate.getName());
        assertEquals(rook.getColor(),pieceAtCoordinate.getColor());
        assertEquals(rook.getPosStr(),pieceAtCoordinate.getPosStr());
    }

    @Test
    void testAreValidCoordinatesWithString() {
        ChessBoard board = new ChessBoard();

        boolean validCoordinates = board.areValidCoordinates("a", "1");
        boolean invalidCoordinates = board.areValidCoordinates("p", "1");

        assertTrue(validCoordinates);
        assertFalse(invalidCoordinates);
    }

    @Test
    void testAreValidCoordinatesWithInt() {
        ChessBoard board = new ChessBoard();

        boolean validCoordinates = board.areValidCoordinates(1,3);
        boolean invalidCoordinates = board.areValidCoordinates(9,2);

        assertTrue(validCoordinates);
        assertFalse(invalidCoordinates);
    }
}