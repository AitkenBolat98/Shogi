package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

public class Bishop extends Piece {

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "B";
    }

    @Override
    public void move(Coordinates from, Coordinates to, Board board) {

    }


    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        return false;
    }

    @Override
    public boolean isPathAvailable(Board board, Coordinates from, Coordinates to) {
        return false;
    }


}
