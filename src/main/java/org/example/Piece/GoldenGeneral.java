package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.HashSet;
import java.util.Set;

public class GoldenGeneral extends Piece {

    public GoldenGeneral(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "G";
    }

    @Override
    public Set<CoordinatesChange> allPossibleMoves(Board board) {
        Set<CoordinatesChange> result = new HashSet<>();
        if(getColor() == Color.WHITE){
            for (int j = -1; j < 2; j++) {
                for (int i = -1; i < 2; i++) {
                    if (j == -1 && i == -1) {
                        continue;
                    }
                    if (j == -1 && i == 1) {
                        continue;
                    }
                    if (j == 0 && i == 0) {
                        continue;
                    }
                    CoordinatesChange change = new CoordinatesChange(j, i);
                    result.add(change);
                }
            }
        }else {
            for (int j = -1; j < 2; j++) {
                for (int i = -1; i < 2; i++) {
                    if (j == 1 && i == 1) {
                        continue;
                    }
                    if (j == 1 && i == -1) {
                        continue;
                    }
                    if (j == 0 && i == 0) {
                        continue;
                    }
                    CoordinatesChange change = new CoordinatesChange(j, i);
                    result.add(change);
                }
            }
        }
        return result;
    }

    @Override
    public boolean isPathOccupiedByFriendly(Coordinates to, Board board) {
        if(board.containsPiece(to)){
            return false;
        }
        return true;
    }
}
