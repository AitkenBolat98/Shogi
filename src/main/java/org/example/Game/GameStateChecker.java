package org.example.Game;

import org.example.Board;
import org.example.Color;
import org.example.Coordinates;
import org.example.KingPath;
import org.example.Piece.King;
import org.example.Piece.Piece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.Piece.King;

public class GameStateChecker {


    public GameState check(Board board, Color color){
        Piece king = board.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        if(!board.isCellUnderAttack(king.getCoordinates(),color.opposite())){
            return GameState.ONGOING;
        }
        List<Piece> friendlyPieces =  board.getPiecesByColor(color);
        KingPath kingPath = new KingPath(color,board);
        Set<Coordinates> enemyPathToKing = kingPath.onKingPathCoordinates(board,king,color);
        for(Piece piece :friendlyPieces){
            for(Coordinates coordinates:enemyPathToKing){
                Set<Coordinates> allyPossibleCoordinates = piece.availableCoordinates(piece.getCoordinates(),coordinates,board);
                if(allyPossibleCoordinates != null){
                    return GameState.ONGOING;
                }
            }
        }
        if(color == Color.WHITE){
            return GameState.CHECKMATE_TO_WHITE;
        }else {
            return GameState.CHECKMATE_TO_BLACK;
        }
    }

}
