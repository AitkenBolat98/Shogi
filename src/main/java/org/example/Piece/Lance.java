package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.Set;

public class Lance extends Piece{

    public Lance(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "L";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        if(color == Color.BLACK){
            for(int i = from.vertical-1; i == to.vertical; i--){
                Coordinates newCoordinatesBlack = new Coordinates(i,from.horizontal);
                if(board.containsPiece(newCoordinatesBlack) && !board.isEnemy(from,newCoordinatesBlack)){
                    break;
                }
                possibleSet.add(newCoordinatesBlack);
            }
        }else {
            for(int j = from.vertical+1; j == to.vertical; j++){
                Coordinates newCoordinatesWhite = new Coordinates(j,from.horizontal);
                if(board.containsPiece(newCoordinatesWhite)){
                    break;
                }
                possibleSet.add(newCoordinatesWhite);
            }
        }

        return possibleSet;
    }


}
