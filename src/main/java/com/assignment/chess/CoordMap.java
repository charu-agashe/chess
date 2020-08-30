package com.assignment.chess;

import java.util.HashMap;

public class CoordMap {
    HashMap<String,Integer> xMap = new HashMap<>();
    HashMap<Integer,String> inversedXMap = new HashMap<>();

    HashMap<String,Integer> yMap = new HashMap<>();
    HashMap<Integer,String> inversedYMap = new HashMap<>();

    public CoordMap() {
        this.putX("a",1);
        this.putX("b",2);
        this.putX("c",3);
        this.putX("d",4);
        this.putX("e",5);
        this.putX("f",6);
        this.putX("g",7);
        this.putX("h",8);

        this.putY("1",1);
        this.putY("2",2);
        this.putY("3",3);
        this.putY("4",4);
        this.putY("5",5);
        this.putY("6",6);
        this.putY("7",7);
        this.putY("8",8);
    }

    void putX(String str, Integer val) {
        xMap.put(str, val);
        inversedXMap.put(val, str);
    }

    void putY(String str, Integer val) {
        yMap.put(str, val);
        inversedYMap.put(val, str);
    }

    Integer getX(String str) {
        return xMap.get(str);
    }

    Integer getY(String str) {
        return yMap.get(str);
    }

    String getXKey(Integer val) {
        return inversedXMap.get(val);
    }

    String getYKey(Integer val) {
        return inversedYMap.get(val);
    }

}
