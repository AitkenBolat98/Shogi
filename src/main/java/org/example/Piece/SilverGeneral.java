package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.Set;

public class SilverGeneral extends Piece{

    public SilverGeneral(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name =  "S";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        Piece piece = board.getPiece(from);
        if (!piece.isPromoted) {
            for (int i = -1; i < 2; i = i + 2) {
                for (int j = -1; j < 2; j++) {
                    if (i == 1 && j == 0) {
                        continue;
                    }
                    Coordinates newCoordinates = new Coordinates(from.vertical + i, from.horizontal + j);
                    if (board.containsPiece(newCoordinates) && !board.isEnemy(from, newCoordinates)) {
                        continue;
                    }
                    possibleSet.add(newCoordinates);
                }
            }
        }else {
            possibleSet = availableCoordinatesAsPromoted(from,board);
        }
        return possibleSet;
    }
}
