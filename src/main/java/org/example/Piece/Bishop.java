package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "B";
    }

    @Override
    public Set<CoordinatesChange> availableCoordinates(Board board){
        HashSet<CoordinatesChange> result = new HashSet<>();

        for(int i = -8; i < 8; i++){
            if(i == 0){
                continue;
            }
            CoordinatesChange change = new CoordinatesChange(i,i);
            result.add(change);
        }

        for (int j = -8;j < 8; j++){
            if(j == 0){
                continue;
            }
            CoordinatesChange change = new CoordinatesChange(j,-j);
            result.add(change);
        }
        return result;
    }
}









