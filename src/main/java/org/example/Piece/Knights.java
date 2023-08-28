package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.ArrayList;
import java.util.Set;

public class Knights extends Piece{
    public Knights(Color color, Coordinates coordinates) {
        super(color, coordinates);
        this.name = "N";
    }

    @Override
    public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board) {

        ArrayList<Coordinates> listOfPossibleCoordinates = new ArrayList<>();

        if(getColor() == Color.WHITE){

            Coordinates whiteOptionOne = new Coordinates(from.vertical+2,from.horizontal-1);
            Coordinates whiteOptionTwo = new Coordinates(from.vertical+2,from.horizontal+1);

            listOfPossibleCoordinates.add(whiteOptionOne);
            listOfPossibleCoordinates.add(whiteOptionTwo);
            }else {

            Coordinates blackOptionOne = new Coordinates(from.vertical - 2,from.horizontal-1);
            Coordinates blackOptionTwo = new Coordinates(from.vertical - 2,from.horizontal +1);

            listOfPossibleCoordinates.add(blackOptionOne);
            listOfPossibleCoordinates.add(blackOptionTwo);
            }
        for(int i = 0; i < listOfPossibleCoordinates.size()-1;i++){
            if(board.containsPiece(listOfPossibleCoordinates.get(i)) &&
                    board.isEnemy(from, listOfPossibleCoordinates.get(i))){
                possibleSet.add(listOfPossibleCoordinates.get(i));
            }
            if(!board.containsPiece(listOfPossibleCoordinates.get(i))){
                possibleSet.add(listOfPossibleCoordinates.get(i));
            }
        }
        return possibleSet;
        }
    }

