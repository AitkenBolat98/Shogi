package org.example.Piece;

import org.example.Color;
import org.example.CoordinateChange;
import org.example.Coordinates;
import org.example.Board;

public class Rook extends Piece{
    private CoordinateChange changeInCoordinates = new CoordinateChange();
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "R";
    }

    @Override
    public boolean isMoveSatisfyLimit(Coordinates from, Coordinates to) {
        int changeInVertical = changeInCoordinates.differenceInCoordinatesVertical(from,to);
        int changeInHorizontal = changeInCoordinates.differenceInCoordinatesHorizontal(from,to);

        if((changeInVertical != 0 && changeInHorizontal == 0) || (changeInVertical == 0 && changeInHorizontal != 0 )){
            return true;
        }
        return false;
    }

    @Override
    public boolean isPathAvailable(Board board, Coordinates from, Coordinates to) {
        int changeInVertical = changeInCoordinates.differenceInCoordinatesVertical(from,to);
        int changeInHorizontal = changeInCoordinates.differenceInCoordinatesHorizontal(from,to);
        Integer newVertical = from.vertical;
        Integer newHorizontal = from.horizontal;
        if(changeInVertical == 0){
            while (changeInHorizontal != 1) {
                if (changeInHorizontal > 0) {
                    newHorizontal += 1;
                    if (isNewCoordinatesOccupied(newHorizontal, from.vertical, board)) {
                        return false;
                    }
                    changeInHorizontal -=1;
                }else {
                    newHorizontal -= 1;
                    if(isNewCoordinatesOccupied(newHorizontal,from.vertical,board)){
                        return false;
                    }
                    changeInHorizontal +=1;
                }
            }
        }else{
            while (changeInVertical != 1){
                if(changeInVertical > 0){
                    newVertical += 1;
                    if(isNewCoordinatesOccupied(from.horizontal,newVertical,board)){
                        return false;
                    }
                    changeInVertical -= 1;
                }else {
                    newVertical -=1;
                    if(isNewCoordinatesOccupied(from.horizontal,newVertical,board)){
                        return false;
                    }
                    changeInVertical += 1;
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



}
