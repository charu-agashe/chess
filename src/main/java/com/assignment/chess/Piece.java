package com.assignment.chess;

import java.util.ArrayList;

public abstract class Piece {
    private String color;
    private String name;
    private int xPosition;
    private int yPosition;
    private ChessBoard board;
    private String posStr;

    public Piece(String name, String color, ChessBoard board, String position) {
        this.name = name;
        this.color = color;
        this.xPosition = -1;
        this.yPosition = -1;
        this.posStr = position;
        this.board = board;
    }

    public void setCoordinates(int x, int y){
            this.xPosition = x;
            this.yPosition = y;
            this.board.setPieceAtCoordinates(this, x, y);
    }

    public boolean addToValidMoves(ArrayList<String> validMoves , int x, int y){
        if(!this.board.areValidCoordinates(x,y)){
            return false;
        }
        Piece pieceAtCoordinate = this.board.getPieceAtCoordinate(x, y);
        if(pieceAtCoordinate == null){
            addMoveToList(validMoves, x, y);
            return false;
        }else if(!pieceAtCoordinate.color.equals(this.color)){
            addMoveToList(validMoves, x, y);
            return true;
        }else{
            return true;
        }
    }

    private void addMoveToList(ArrayList<String> validMoves, int x, int y) {
        String positionVal = "" + board.getCoordMap().getXKey(x) + board.getCoordMap().getYKey(y);
        validMoves.add(positionVal);
    }

    public String getColor() {
        return color;
    }

    public String getName(){
        return name;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public String getPosStr() {
        return posStr;
    }


    public abstract ArrayList<String> getPossibleMoves();
}
