package org.example.Piece;

import org.example.Color;
import org.example.CoordinateChange;
import org.example.Coordinates;
import org.example.Board;

public class Lance extends Piece{

    private CoordinateChange changeInCoordinates = new CoordinateChange();
    public Lance(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "L";
    }


    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        int horizontalChange = changeInCoordinates.differenceInCoordinatesHorizontal(from,to);
        if(horizontalChange != 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean isPathAvailable(Board board, Coordinates from, Coordinates to) {
        int verticalChange = changeInCoordinates.differenceInCoordinatesVertical(from,to);
        int newVertical = from.vertical;
        while (Math.abs(verticalChange) != 1){
            if(verticalChange > 0){
                newVertical += 1;
                if(isNewCoordinatesOccupied(from.horizontal,newVertical,board)){
                    return false;
                }else {
                    verticalChange += 1;
                }
            }else {
                newVertical -= 1;
                if(isNewCoordinatesOccupied(from.horizontal,newVertical,board)){
                    return false;
                }else {
                    verticalChange -= 1;
                }
            }
            if(board.containsPiece(to)){
                if(board.isEnemy(from,to)){
                    eatEnemy(board,to);
                }else {
                    return false;
                }
            }

        }return true;
    }




}
