package org.example.Piece;

import org.example.Color;
import org.example.CoordinateChange;
import org.example.Coordinates;
import org.example.Board;
import java.lang.Math;

public class Bishop extends Piece {
    private CoordinateChange changeInCoordinates = new CoordinateChange();

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "B";
    }

    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        int changeHorizontal = changeInCoordinates.differenceInCoordinatesHorizontal(from, to);
        int changeVertical = changeInCoordinates.differenceInCoordinatesVertical(from, to);
        int change = Math.abs(changeHorizontal) - Math.abs(changeVertical);
        if (change == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPathAvailable(Board board, Coordinates from, Coordinates to) {

        int changeHorizontal = changeInCoordinates.differenceInCoordinatesHorizontal(from, to);
        int changeVertical = changeInCoordinates.differenceInCoordinatesVertical(from, to);
        Integer newVertical = from.vertical;
        Integer newHorizontal = from.horizontal;
        while (Math.abs(changeHorizontal) != 1 && Math.abs(changeVertical) != 1) {
            if (changeVertical > 0 && changeHorizontal > 0) {
                newVertical += 1;
                newHorizontal += 1;
                if (isNewCoordinatesOccupied(newHorizontal, newVertical, board)) {
                    return false;
                } else {
                    changeHorizontal = changeHorizontal - 1;
                    changeVertical = changeVertical - 1;
                }
            } else if (changeVertical > 0 && changeHorizontal < 0) {
                newVertical += 1;
                newHorizontal -= 1;
                if (isNewCoordinatesOccupied(newHorizontal, newVertical, board)) {
                    return false;
                } else {
                    changeHorizontal = changeHorizontal + 1;
                    changeVertical = changeVertical - 1;
                }
            } else if (changeVertical < 0 && changeHorizontal > 0) {
                newVertical -= 1;
                newHorizontal += 1;
                if (isNewCoordinatesOccupied(newHorizontal, newVertical, board)) {
                    return false;
                } else {
                    changeHorizontal = changeHorizontal - 1;
                    changeVertical = changeVertical + 1;
                }
            } else if (changeVertical < 0 && changeHorizontal < 0) {
                newVertical -= 1;
                newHorizontal -= 1;
                if (isNewCoordinatesOccupied(newHorizontal, newVertical, board)) {
                    return false;
                } else {
                    changeHorizontal = changeHorizontal + 1;
                    changeVertical = changeVertical + 1;
                }
            }

        }
        if(board.containsPiece(to)){
            if(board.isEnemy(from,to)){
                eatEnemy(board,to);
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void eatEnemy(Board board, Coordinates to) {
        Piece pieceTo = board.getPiece(to);
        board.putInHold(pieceTo);
        board.deletePiece(to);
    }




}
