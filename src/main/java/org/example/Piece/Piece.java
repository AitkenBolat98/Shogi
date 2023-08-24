package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {

    public Coordinates coordinates;
    public Color color;
    protected boolean isPromoted = false;
    protected String name;

    public HashSet<Coordinates> possibleSet;
    public Piece(Color color,Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
    public String getName() {
        return name;
    }

    public void move(Coordinates from,Coordinates to,Board board){
        Piece piece = board.getPiece(from);
        board.deletePiece(from);
        board.setPiece(to,piece);
    }

    abstract public Set<Coordinates> availableCoordinates(Coordinates from, Coordinates to, Board board);

    public void eatEnemy(Board board, Coordinates to){
        Piece pieceTo = board.getPiece(to);
        board.putInHold(pieceTo);
        board.deletePiece(to);
    }

    public boolean isNewCoordinatesOccupied(Integer newHorizontal, Integer newVertical, Board board) {
        Coordinates newCoordinates = new Coordinates(newVertical, newHorizontal);
        if (board.containsPiece(newCoordinates)) {
            return true;
        }
        return false;
    }
}
