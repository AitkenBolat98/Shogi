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
        Piece piece = board.getPiece(from);
        int shiftHorizontal = to.horizontal - from.horizontal;
        int shiftVertical = to.vertical - from.vertical;
        if(shiftHorizontal > 0){
            for(int i = 0; i < shiftHorizontal;i++){
                Coordinates possibleHorizontalCoordinates = new Coordinates(from.vertical,from.horizontal+i);
                if (board.containsPiece(possibleHorizontalCoordinates) && !board.isEnemy(from, possibleHorizontalCoordinates)) {
                    break;
                }
                possibleSet.add(possibleHorizontalCoordinates);
            }
        }else {
            for(int i = 0; i < shiftHorizontal;i++){
                Coordinates possibleHorizontalCoordinates = new Coordinates(from.vertical,from.horizontal-i);
                if (board.containsPiece(possibleHorizontalCoordinates) && !board.isEnemy(from, possibleHorizontalCoordinates)) {
                    break;
                }
                possibleSet.add(possibleHorizontalCoordinates);
            }
        }
        if(shiftVertical>0){
            for(int i = 0; i < shiftVertical;i++){
                Coordinates possibleVerticalCoordinates = new Coordinates(from.vertical+i,from.horizontal);
                if (board.containsPiece(possibleVerticalCoordinates) && !board.isEnemy(from, possibleVerticalCoordinates)) {
                    break;
                }
                possibleSet.add(possibleVerticalCoordinates);
            }
        }else {
            for(int i = 0; i < shiftVertical;i++){
                Coordinates possibleVerticalCoordinates = new Coordinates(from.vertical-i,from.horizontal);
                if (board.containsPiece(possibleVerticalCoordinates) && !board.isEnemy(from, possibleVerticalCoordinates)) {
                    break;
                }
                possibleSet.add(possibleVerticalCoordinates);
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
