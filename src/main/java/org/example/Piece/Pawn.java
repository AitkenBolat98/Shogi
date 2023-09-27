package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "P";
    }

    @Override
    public Set<CoordinatesChange> allPossibleMoves(Board board) {
        HashSet<CoordinatesChange> result = new HashSet<>();
        if(getColor() == Color.WHITE){
            CoordinatesChange move = new CoordinatesChange(1,0);
            result.add(move);
        }else {
            CoordinatesChange move = new CoordinatesChange(-1,0);
            result.add(move);
        }
        return result;
    }

    @Override
    protected boolean isPathOccupiedByFriendly(Coordinates to, Board board) {
        if(!board.containsPiece(to) || !board.isCellOccupiedByEnemy(to,getColor())) {
            return false;
        }
        return true;
    }


}

