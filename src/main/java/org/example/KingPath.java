package org.example;

import org.example.Piece.King;
import org.example.Piece.Piece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KingPath {
    private final Board board;
    private Color color;
    public KingPath(Color color,Board board){
        this.board = board;
        this.color = color;


    }
    public Set<Coordinates> onKingPathCoordinates(Board board, Piece king, Color color){
        List<Piece> enemyPieces = board.getPiecesByColor(color.opposite());
        Set<Coordinates> result = new HashSet<>();
        for(Piece piece:enemyPieces){
            Set<Coordinates> pieceAvailableCoordinates = piece.availableCoordinates(piece.getCoordinates(),king.getCoordinates(),board);
            result.addAll(pieceAvailableCoordinates);
        }
        return result;
    }
}
