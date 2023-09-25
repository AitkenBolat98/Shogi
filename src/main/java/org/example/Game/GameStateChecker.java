package org.example.Game;

import org.example.*;
import org.example.Piece.King;
import org.example.Piece.Piece;

import java.util.List;
import java.util.Set;

public class GameStateChecker {


    public GameState check(Board board, Color color){
        Piece king = board.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();

        if(!board.isCellAttackedByColor(color,king.getCoordinates())){
            return GameState.ONGOING;
        }

        List<Piece> friendlyPieces =  board.getPiecesByColor(color);
        for(Piece piece:friendlyPieces){
            Set<Coordinates> availableMovesForPiece = piece.getAvailableMoves(board);
            for(Coordinates coordinates:availableMovesForPiece){
                Board cloneBoard = board.makeCopy(board);
                Move move = new Move(piece.getCoordinates(),coordinates);
                cloneBoard.createMove(move);

                Piece cloneKing = cloneBoard.getPiecesByColor(color).stream().filter(piece1 -> piece1 instanceof King).findFirst().get();
                if(!cloneBoard.isCellAttackedByColor(color.opposite(),cloneKing.getCoordinates())){
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
