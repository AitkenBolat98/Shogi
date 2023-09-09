package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "B";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        Piece piece = board.getPiece(from);
        for (int i = 8; i > 0; i--) {
            Coordinates possibleCoordinatesBottomToTop = new Coordinates(8, 8-i);
            if (board.containsPiece(possibleCoordinatesBottomToTop) && !board.isEnemy(from, possibleCoordinatesBottomToTop)) {
                break;
            }
            possibleSet.add(possibleCoordinatesBottomToTop);
        }
        for (int j = 0; j < 9; j++) {
            Coordinates possibleCoordinatesTopToBottom = new Coordinates(j, j);
            if (board.containsPiece(possibleCoordinatesTopToBottom) && !board.isEnemy(from, possibleCoordinatesTopToBottom)) {
                break;
            }
            possibleSet.add(possibleCoordinatesTopToBottom);
        }
        if(piece.isPromoted){
            for(int j = -1;j < 2; j ++) {
                for (int i = -1; i < 2; i++) {
                    if (i == 0 & j == 0) {
                        continue;
                    }
                    Coordinates newCoordinates = new Coordinates(from.vertical+j,from.horizontal+i);
                    possibleSet.add(newCoordinates);
                }
            }
        }
        if(piece.isPromoted){
            for(int j = -1;j < 2; j ++) {
                for (int i = -1; i < 2; i++) {
                    if (i == 0 & j == 0) {
                        continue;
                    }
                    Coordinates newCoordinates = new Coordinates(from.vertical+j,from.horizontal+i);
                    possibleSet.add(newCoordinates);
                }
            }
        }
        return possibleSet;
    }
}









