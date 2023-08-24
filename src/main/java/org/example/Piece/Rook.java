package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.Set;

public class Rook extends Piece{
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "R";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        for(int i = 0; i < 8;i++) {
            Coordinates possibleHorizontalCoordinates = new Coordinates(from.vertical, i);
            if (board.containsPiece(possibleHorizontalCoordinates) && !board.isEnemy(from, possibleHorizontalCoordinates)) {
                break;
            }
            possibleSet.add(possibleHorizontalCoordinates);
        }
        for(int j = 0; j < 8;j++){
            Coordinates possibleVerticalCoordinates = new Coordinates(j, from.horizontal);
            if(board.containsPiece(possibleVerticalCoordinates) && !board.isEnemy(from,possibleVerticalCoordinates)){
                break;
            }
            possibleSet.add(possibleVerticalCoordinates);
        }
        return possibleSet;
    }


}
