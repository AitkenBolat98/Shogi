package org.example.Piece;

import org.example.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lance extends Piece{

    public Lance(Color color, Coordinates coordinates,boolean isPromoted) {
        super(color, coordinates);
        this.name = "L";
        this.isPromoted = isPromoted;
    }

    @Override
    public Set<CoordinatesChange> allPossibleMoves(Board board) {
        if(isPromoted){
            return allPossibleMovesAsPromoted();
        }
        Set<CoordinatesChange> result = new HashSet<>();
        if(getColor() == Color.WHITE){
            for(int i = 1; i < 9;i ++){
                CoordinatesChange change = new CoordinatesChange(i,0);
                result.add(change);
            }
        }else {
            for(int i = 1; i < 9;i ++){
                CoordinatesChange change = new CoordinatesChange(-i,0);
                result.add(change);
            }
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


