package org.example;

import org.example.Piece.Piece;

public class Game {
    private final Board board;
    private final MapRenderer mapRenderer;

    public Game(Board board,MapRenderer mapRenderer) {
        this.board = board;
        this.mapRenderer = mapRenderer;
    }

    public void gameLoop(){
        boolean isWhiteToMove = true;
        while (true){
            mapRenderer.render(board);
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE:Color.BLACK,board);
            Piece piece = board.getPiece(sourceCoordinates);
            Coordinates targetCoordinates = InputCoordinates.targetCoordinatesApproval(
                    piece,sourceCoordinates,board);
            piece.move(sourceCoordinates,targetCoordinates,board);
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
