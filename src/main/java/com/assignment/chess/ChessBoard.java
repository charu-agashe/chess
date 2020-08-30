package com.assignment.chess;

public class ChessBoard {

    private int height = 8;

    private int width = 8;
    private Piece squares[][];

    private CoordMap coordMap;

    public ChessBoard() {
        this.squares = new Piece[8][];
        for(int i = 0; i < 8; i++) {
            this.squares[i] = new Piece[8];
        }
        this.coordMap = new CoordMap();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public CoordMap getCoordMap(){
        return coordMap;
    }

    public Piece getPieceAtCoordinate(int x, int y){
        if(x >= this.width || y >= this.height || x <0 || y < 0){
            return null;
        }
        return this.squares[x][y];
    }

    public void setPieceAtCoordinates(Piece p , int x, int y){
        this.squares[x][y] = p;
    }

    public boolean areValidCoordinates(String xVal, String yVal){
        if(this.getCoordMap().getX(xVal) != null && this.getCoordMap().getY(yVal) != null){
            return true;
        }
        return false;
    }

    public boolean areValidCoordinates(int xVal, int yVal){
        if(this.getCoordMap().getXKey(xVal) != null && this.getCoordMap().getYKey(yVal) != null){
            return true;
        }
        return false;
    }

}
