package org.example.Game;

import org.example.Board;
import org.example.Color;
import org.example.Piece.King;
import org.example.Piece.Piece;

public class GameStateChecker {

    public GameState check(Board board, Color color){
        Piece king = board.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        if(board.isCellUnderAttack(king.getCoordinates(),color.opposite())){
            return GameState.ONGOING;
        }

    return GameState.ONGOING;
    }

}
