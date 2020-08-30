package com.assignment.chess;

import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(String name, String color, ChessBoard board, String position) {
        super("knight", color, board, position);
    }


    @Override
    public ArrayList<String> getPossibleMoves() {
        ChessBoard board = this.getBoard();
        ArrayList<String> validMoves = new ArrayList<>();
        int currentX = this.getXPosition();
        int currentY = this.getYPosition();
        int x, y;

        // left
        x = currentX - 2;
        y = currentY + 1;
        if(x > 0 && y <= board.getHeight()){
            addToValidMoves(validMoves, x, y);
        }
        x = currentX - 2;
        y = currentY - 1;
        if(x > 0 && y > 0 ){
            addToValidMoves(validMoves, x, y);
        }

        // below
        x = currentX - 1;
        y = currentY - 2;
        if(x > 0 && y > 0){
            addToValidMoves(validMoves, x, y);
        }

        x = currentX + 1;
        y = currentY - 2;
        if(x <= board.getWidth() && y > 0){
            addToValidMoves(validMoves, x, y);
        }

        // above
        x = currentX + 1;
        y = currentY + 2;
        if(x <= board.getWidth() && y <= board.getHeight()){
            addToValidMoves(validMoves, x, y);
        }

        x = currentX - 1;
        y = currentY + 2;
        if(x > 0 && y <= board.getHeight()){
            addToValidMoves(validMoves, x, y);
        }


        // right
        x = currentX + 2;
        y = currentY - 1;
        if(x <= board.getWidth() && y > 0){
            addToValidMoves(validMoves, x, y);
        }

        x = currentX + 2;
        y = currentY + 1;
        if(x <= board.getWidth() && y <= board.getHeight()){
            addToValidMoves(validMoves, x, y);
        }
        return validMoves;
    }
}
