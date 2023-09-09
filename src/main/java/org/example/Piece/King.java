package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.Set;

public class King extends Piece{
    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "K";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {
        for(int j = -1;j < 2; j ++){
            for(int i = -1;i < 2;i++){
                if(i == 0 & j == 0){
                    continue;
                }
                Coordinates newCoordinates = new Coordinates(from.vertical+j,from.horizontal+i);
                if (board.containsPiece(newCoordinates) && !board.isEnemy(from, newCoordinates)) {
                    continue;
                }

                if(board.isCellUnderAttack(newCoordinates,getColor().opposite())){
                    continue;
                }
                possibleSet.add(newCoordinates);
                }
            }
        return possibleSet;
    }

}
