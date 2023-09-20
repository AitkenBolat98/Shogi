package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class King extends Piece{
    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "K";
    }

    @Override
    public Set<CoordinatesChange> availableCoordinates(Board board) {
        Set<CoordinatesChange> result = new HashSet<>();
        for(int i = -1 ; i < 2; i++){
            for(int j = -1; j < 2;j++){
                if(i == 0 & j == 0){
                    continue;
                }
                CoordinatesChange change = new CoordinatesChange(i,j);
                result.add(change);
            }
        }
        return result;
    }



}
