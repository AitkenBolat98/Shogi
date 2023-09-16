package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.Set;

public class GoldenGeneral extends Piece {

    public GoldenGeneral(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "G";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        for(int j = -1;j < 2; j ++){
            for(int i = -1;i < 2;i++){
                if(Math.abs(to.vertical - from.vertical)>1){
                    continue;
                }
                if(j == 1 && i ==-1){
                    continue;
                }
                if(j == 1 && i == 1){
                    continue;
                }
                if(j == 0 && i == 0){
                    continue;
                }
                Coordinates newCoordinates = new Coordinates(from.vertical+j,from.horizontal+i);
                if(board.containsPiece(newCoordinates) && !board.isEnemy(from,newCoordinates)){
                    continue;
                }
                possibleSet.add(newCoordinates);
                }
            }
        return  possibleSet;
    }


}