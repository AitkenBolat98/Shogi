package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

abstract public class Piece {

    public Coordinates coordinates;
    public Color color;
    protected boolean isPromoted = false;
    protected String name;
    public Piece(Color color,Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
    abstract public void move(Coordinates from, Coordinates to, Board board);
    public String getName() {
        return name;
    }
    public boolean isNotOutOfBounds(Coordinates to){
        if(to.horizontal < 9 || to.vertical < 9){
            return true;
        }else {
            return false;
        }
    }

    abstract public boolean isMoveSatisfyLimit(Coordinates from,Coordinates to);

    abstract public boolean isPathAvailable(Board board, Coordinates from, Coordinates to);
}
