package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "P";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        Piece piece = board.getPiece(from);
        if(!piece.isPromoted) {
            if (getColor() == Color.WHITE) {
                if (to.vertical - from.vertical == 1) {
                    possibleSet.add(to);
                }
            } else {
                if (to.vertical - from.vertical == -1) {
                    possibleSet.add(to);
                }
            }
            return possibleSet;
        }else {

        }
    }


}

