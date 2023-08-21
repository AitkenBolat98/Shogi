package org.example.Piece;

import org.example.Color;
import org.example.CoordinateChange;
import org.example.Coordinates;
import org.example.Board;

public class Pawn extends Piece {
    private CoordinateChange changeInCoordinates = new CoordinateChange();
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "P";
    }

    @Override
    public void move(Coordinates from, Coordinates to,Board board) {
            Piece piece = board.getPiece(from);
            board.deletePiece(from);
            board.setPiece(to,piece);

    }

    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        int change = changeInCoordinates.differenceInCoordinatesVertical(from,to);
        if (change == 1 || change == -1) {
            return true;
        } else {
            return false;
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

