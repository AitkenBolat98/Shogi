package org.example.Piece;

import org.example.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends Piece{
    public Rook(Color color, Coordinates coordinates,boolean isPromoted) {
        super(color, coordinates);
        this.name = "R";
        this.isPromoted = isPromoted;
    }

    @Override
    public Set<CoordinatesChange> allPossibleMoves(Board board) {
        Set<CoordinatesChange> result = new HashSet<>();
        for(int i = -8; i < 8; i++){
            if(i == 0){
                continue;
            }
            CoordinatesChange change = new CoordinatesChange(i,0);
            result.add(change);
        }
        for(int j = -8; j < 8; j++){
            if(j == 0){
                continue;
            }
            CoordinatesChange change = new CoordinatesChange(0,j);
            result.add(change);
        }
        if(this.isPromoted){
            Set<CoordinatesChange> promotedMoves = allPossibleMovesAsPromoted();
            result.addAll(promotedMoves);
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
    @Override
    protected Set<CoordinatesChange> allPossibleMovesAsPromoted(){
        Set<CoordinatesChange> result = new HashSet<>();
        if(getColor() == Color.WHITE){
            for (int j = -1; j < 2; j++) {
                for (int i = -1; i < 2; i++) {
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
    }
