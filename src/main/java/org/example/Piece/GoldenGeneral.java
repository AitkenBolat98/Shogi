package org.example.Piece;

import org.example.Color;
import org.example.CoordinateChange;
import org.example.Coordinates;
import org.example.Board;

public class GoldenGeneral extends Piece {

    private final CoordinateChange changeInCoordinates = new CoordinateChange();
    public GoldenGeneral(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "G";
    }

    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        int changeInVertical = changeInCoordinates.differenceInCoordinatesVertical(from, to);
        int changeInHorizontal = changeInCoordinates.differenceInCoordinatesHorizontal(from, to);
        if(color == Color.BLACK) {
            if ((changeInHorizontal == -1 && changeInVertical == 1) ||
                    (changeInHorizontal == 1 && changeInVertical == -1)) {
                return false;
            }
            if (Math.abs(changeInHorizontal) > 1 || Math.abs(changeInVertical) > 1) {
                return false;
            }
            return true;
        }else {
            if ((changeInHorizontal == -1 && changeInVertical == -1) ||
                    (changeInHorizontal == 1 && changeInVertical == -1)) {
                return false;
            }
            if (Math.abs(changeInHorizontal) > 1 || Math.abs(changeInVertical) > 1) {
                return false;
            }
            return true;
        }
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