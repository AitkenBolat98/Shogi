package org.example.Piece;

import org.example.Color;
import org.example.CoordinateChange;
import org.example.Coordinates;
import org.example.Board;

public class SilverGeneral extends Piece{

    CoordinateChange changeInCoordinates = new CoordinateChange();
    public SilverGeneral(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name =  "S";
    }

    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        int horizontalChange = changeInCoordinates.differenceInCoordinatesHorizontal(from,to);
        int verticalChange = changeInCoordinates.differenceInCoordinatesVertical(from,to);
            if(horizontalChange == 0 && verticalChange == -1){
                return false;
            }
            if(verticalChange == 0 && Math.abs(horizontalChange) == 1){
                return false;
            }
            return true;

    }

    @Override
    public boolean isPathAvailable(Board board, Coordinates from, Coordinates to) {
        if (board.containsPiece(to)) {
            if (board.isEnemy(from, to)) {
                board.putInHold(board.getPiece(to));
                board.deletePiece(to);
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }



}
