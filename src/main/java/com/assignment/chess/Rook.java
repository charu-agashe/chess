package com.assignment.chess;

import java.util.ArrayList;

public class Rook extends  Piece {
    public Rook(String name, String color, ChessBoard board, String position) {
        super("rook", color, board, position);
    }

    public ArrayList<String> getPossibleMoves(){
        int x = this.getXPosition();
        int y = this.getYPosition();

        ArrayList<String> validMoves = new ArrayList<>();

        for(int i = x -1 ; i > 0 ; i--){
            if(addToValidMoves(validMoves,i,y))
                break;
        }

        for(int i = x + 1 ; i <= this.getBoard().getWidth() ; i++){
            if(addToValidMoves(validMoves,i,y))
                break;
        }

        for(int i = y + 1; i <= this.getBoard().getHeight() ; i++){
            if(addToValidMoves(validMoves,x,i))
                break;
        }

        for(int i = y - 1; i > 0 ; i--){
            if(addToValidMoves(validMoves,x,i))
                break;
        }
        return validMoves;
    }


}
