package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

public class Lance extends Piece{
    public Lance(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "L";
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
