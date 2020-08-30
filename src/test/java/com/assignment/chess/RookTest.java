package com.assignment.chess;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    void testGetPossibleMoveCoordinateWithOneRook() {
        ChessBoard board = new ChessBoard();
        Rook rook = new Rook("R","W",board,"a1" );
        rook.setCoordinates(1,1);
        board.setPieceAtCoordinates(rook,1,1);

        ArrayList<String> possibleMoves = rook.getPossibleMoves();
        assertEquals(14, possibleMoves.size());
        Collections.sort(possibleMoves);
        assertEquals("a2", possibleMoves.get(0));
    }

    @Test
    void testGetPossibleMoveCoordinateWithTwoRooks() {
        ChessBoard board = new ChessBoard();
        Rook rook1 = new Rook("R","W",board,"a1" );
        rook1.setCoordinates(1,1);
        board.setPieceAtCoordinates(rook1,1,1);

        Rook rook2 = new Rook("R","W",board,"b1" );
        rook2.setCoordinates(2,1);
        board.setPieceAtCoordinates(rook2,2,1);

        ArrayList<String> possibleMoves1= rook1.getPossibleMoves();
        assertEquals(7, possibleMoves1.size());
        Collections.sort(possibleMoves1);
        assertEquals("a2", possibleMoves1.get(0));

        ArrayList<String> possibleMoves2 = rook2.getPossibleMoves();
        assertEquals(13, possibleMoves2.size());
        Collections.sort(possibleMoves2);
        assertEquals("b2", possibleMoves2.get(0));
    }

    @Test
    void testGetPossibleMoveCoordinateWithTwoRooksOfDifferentColors() {
        ChessBoard board = new ChessBoard();
        Rook rook1 = new Rook("R","W",board,"a1" );
        rook1.setCoordinates(1,1);
        board.setPieceAtCoordinates(rook1,1,1);

        Rook rook2 = new Rook("R","B",board,"b1" );
        rook2.setCoordinates(2,1);
        board.setPieceAtCoordinates(rook2,2,1);


        ArrayList<String> possibleMoves1= rook1.getPossibleMoves();
        assertEquals(8, possibleMoves1.size());
        Collections.sort(possibleMoves1);
        assertEquals("a2", possibleMoves1.get(0));

        ArrayList<String> possibleMoves2 = rook2.getPossibleMoves();
        assertEquals(14, possibleMoves2.size());
        Collections.sort(possibleMoves2);
        assertEquals("a1", possibleMoves2.get(0));
    }
}