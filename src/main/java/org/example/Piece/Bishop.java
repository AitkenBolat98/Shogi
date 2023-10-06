package org.example.Piece;

import org.example.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Color color, Coordinates coordinates,boolean isPromoted) {
        super(color, coordinates);
        this.name = "B";
        this.isPromoted = isPromoted;
    }

    @Override
    public Set<CoordinatesChange> allPossibleMoves(Board board){
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

    @Override
    public boolean isPathOccupiedByFriendly(Coordinates to, Board board){
        List<Coordinates> coordinatesBetween;

        if(this.coordinates.vertical == to.vertical){
            coordinatesBetween = BoardShifts.getVerticalCoordinatesBetween(this.coordinates,to);
        }else if(this.coordinates.horizontal == to.horizontal){
            coordinatesBetween = BoardShifts.getHorizontalCoordinatesBetween(this.coordinates,to);
        }else {
            coordinatesBetween = BoardShifts.getDiagonalCoordinatesBetween(this.coordinates,to);
        }

        for(Coordinates x : coordinatesBetween){
            if(board.containsPiece(x)){
                return false;
            }
        }
        return true;
    }
}









