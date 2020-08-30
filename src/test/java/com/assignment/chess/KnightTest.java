package com.assignment.chess;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void testGetPossibleMoveCoordinateWithOneKnight() {
        ChessBoard board = new ChessBoard();
        Knight knight = new Knight("R","W",board,"a1" );
        knight.setCoordinates(1,1);
        board.setPieceAtCoordinates(knight,1,1);

        ArrayList<String> possibleMoves = knight.getPossibleMoves();
        assertEquals(2, possibleMoves.size());
        Collections.sort(possibleMoves);
        assertEquals("b3", possibleMoves.get(0));
    }

    @Test
    void testGetPossibleMoveCoordinateWithTwoKnights() {
        ChessBoard board = new ChessBoard();
        Knight knight1 = new Knight("R","W",board,"d1" );
        knight1.setCoordinates(4,1);
        board.setPieceAtCoordinates(knight1,4,1);

        Knight knight2 = new Knight("R","W",board,"e3" );
        knight2.setCoordinates(5,3);
        board.setPieceAtCoordinates(knight2,5,3);

        ArrayList<String> possibleMoves1= knight1.getPossibleMoves();
        assertEquals(3, possibleMoves1.size());
        Collections.sort(possibleMoves1);
        assertEquals("b2", possibleMoves1.get(0));

        ArrayList<String> possibleMoves2 = knight2.getPossibleMoves();
        assertEquals(7, possibleMoves2.size());
        Collections.sort(possibleMoves2);
        assertEquals("c2", possibleMoves2.get(0));
    }

    @Test
    void testGetPossibleMoveCoordinateWithTwoKnightsOfDifferentColors() {
        ChessBoard board = new ChessBoard();
        Knight knight1 = new Knight("R","W",board,"d1" );
        knight1.setCoordinates(4,1);
        board.setPieceAtCoordinates(knight1,4,1);

        Knight knight2 = new Knight("R","B",board,"e3" );
        knight2.setCoordinates(5,3);
        board.setPieceAtCoordinates(knight2,5,3);


        ArrayList<String> possibleMoves1= knight1.getPossibleMoves();
        assertEquals(4, possibleMoves1.size());
        Collections.sort(possibleMoves1);
        assertEquals("b2", possibleMoves1.get(0));

        ArrayList<String> possibleMoves2 = knight2.getPossibleMoves();
        assertEquals(8, possibleMoves2.size());
        Collections.sort(possibleMoves2);
        assertEquals("c2", possibleMoves2.get(0));
    }
}