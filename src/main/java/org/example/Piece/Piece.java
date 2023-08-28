package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

abstract public class Piece {

    private Coordinates coordinates;
    private Color color;
    protected boolean isPromoted = false;
    protected String name;

    public HashSet<Coordinates> possibleSet = new HashSet<>();
    public Piece(Color color,Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
    public String getName() {
        return name;
    }

    public void move(Coordinates from,Coordinates to,Board board){
        if(board.containsPiece(to)){
            eatEnemy(board,to);
        }
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
    public boolean isPieceInPromotionZone(Coordinates coordinates,Piece piece){
        HashSet<Coordinates> promotionZone = coordinates.promotionZone(piece);
        if(promotionZone.contains(coordinates)){
            return true;
        }
        return false;
    }

    public void promotePiece(Piece piece){
        piece.isPromoted = true;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPromoted() {
        return isPromoted;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

}
