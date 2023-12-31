package org.example.Piece;

import org.example.Color;
import org.example.Coordinates;
import org.example.Board;
import org.example.CoordinatesChange;

import java.util.HashSet;

import java.util.Set;

abstract public class Piece {

    public Coordinates coordinates;
    private final Color color;
    protected boolean isPromoted = false;
    protected String name;

    public Piece(Color color,Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
    public String getName() {
        return name;
    }

    abstract public Set<CoordinatesChange> allPossibleMoves(Board board);
    public Set<Coordinates> getAvailableMoves(Board board){
        Set<Coordinates> result = new HashSet<>();
        for(CoordinatesChange change : allPossibleMoves(board)){
            if(coordinates.isChangePossible(change)){
                Coordinates newCoordinates = coordinates.change(change);
                if(isCellAvailableForMove(coordinates,board)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }
    protected boolean isCellAvailableForMove(Coordinates coordinates,Board board){
        if(board.containsPiece(coordinates)|| board.getPiece(coordinates).getColor() != color){
            return true;
        }
        return false;
    }

    public abstract boolean isPathOccupiedByFriendly(Coordinates to,Board board);

    protected Set<CoordinatesChange> allPossibleMovesAsPromoted(){
        Set<CoordinatesChange> result = new HashSet<>();
        if(getColor() == Color.WHITE){
            for (int j = -1; j < 2; j++) {
                for (int i = -1; i < 2; i++) {
                    if (j == -1 && i == -1) {
                        continue;
                    }
                    if (j == -1 && i == 1) {
                        continue;
                    }
                    if (j == 0 && i == 0) {
                        continue;
                    }
                    CoordinatesChange change = new CoordinatesChange(j, i);
                    result.add(change);
                }
            }
        }else {
            for (int j = -1; j < 2; j++) {
                for (int i = -1; i < 2; i++) {
                    if (j == 1 && i == 1) {
                        continue;
                    }
                    if (j == 1 && i == -1) {
                        continue;
                    }
                    if (j == 0 && i == 0) {
                        continue;
                    }
                    CoordinatesChange change = new CoordinatesChange(j, i);
                    result.add(change);
                }
            }
        }
        return result;
    }
    protected Set<CoordinatesChange> getPieceAttacks(Board board){
        return allPossibleMoves(board);
    }

    public Set<Coordinates> getAttackedCells(Board board){
        Set<CoordinatesChange> pieceAttacks = getPieceAttacks(board);
        Set<Coordinates> result = new HashSet<>();

        for(CoordinatesChange pieceAttack:pieceAttacks){
            if(coordinates.isChangePossible(pieceAttack)) {
                Coordinates newCoordinates = coordinates.change(pieceAttack);
                result.add(newCoordinates);
            }
        }
        return result;
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
