package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.HashSet;
import java.util.Set;

public class Lance extends Piece{

    public Lance(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "L";
    }

    @Override
    public Set<CoordinatesChange> availableCoordinates(Board board) {
        Set<CoordinatesChange> result = new HashSet<>();
        if(getColor() == Color.WHITE){
            for(int i = 1; i < 9;i ++){
                CoordinatesChange change = new CoordinatesChange(-i,0);
                result.add(change);
            }
        }else {
            for(int i = 1; i < 9;i ++){
                CoordinatesChange change = new CoordinatesChange(i,0);
                result.add(change);
            }
        }
        return result;
    }

}
