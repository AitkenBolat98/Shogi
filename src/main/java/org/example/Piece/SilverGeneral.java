package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.HashSet;
import java.util.Set;

public class SilverGeneral extends Piece{

    public SilverGeneral(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name =  "S";
    }

    @Override
    public Set<CoordinatesChange> availableCoordinates(Board board) {
        Set<CoordinatesChange> result = new HashSet<>();
            for(int i = -1;i < 2; i += 2){
                for(int j = 0; j < 3;j++){
                    if(i == -1 && j == 0){
                        continue;
                    }
                    CoordinatesChange change = new CoordinatesChange(i,j);
                    result.add(change);
                }
            }
        return result;
    }
}
