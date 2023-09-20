package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Knights extends Piece {
    public Knights(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "N";
    }

    @Override
    public Set<CoordinatesChange> availableCoordinates(Board board) {

        Set<CoordinatesChange> result = new HashSet<>();

            if (getColor() == Color.WHITE) {

                CoordinatesChange whiteOptionOne = new CoordinatesChange(2,  - 1);
                CoordinatesChange whiteOptionTwo = new CoordinatesChange(2, + 1);

                result.add(whiteOptionOne);
                result.add(whiteOptionTwo);
            } else {

                CoordinatesChange blackOptionOne = new CoordinatesChange(2,- 1);
                CoordinatesChange blackOptionTwo = new CoordinatesChange(2,1);

                result.add(blackOptionOne);
                result.add(blackOptionTwo);;
            }

        return result;
    }
}
