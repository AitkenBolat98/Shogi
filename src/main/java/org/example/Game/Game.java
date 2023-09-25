package org.example.Game;

import org.example.*;
import org.example.Piece.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final MapRenderer mapRenderer;
    static Scanner scanner = new Scanner(System.in);
    List<GameStateChecker> gameStateCheckerList = List.of(new GameStateChecker());
    public Game(Board board,MapRenderer mapRenderer) {
        this.board = board;
        this.mapRenderer = mapRenderer;
    }

    public void gameLoop(){
        Color colorToMove = Color.WHITE;
        GameState state = determineGameState(board,colorToMove);
        while (state == GameState.ONGOING){
            mapRenderer.render(board);
            if(playerWantToReturnPieceFromHold(colorToMove)){

                board.hold.displayPiecesInHold(colorToMove);
                Piece chosenPiece = playerChosenPieceFromHold(colorToMove);
                Coordinates coordinatesForChosenPiece = InputCoordinates.inputReturnedPieceCoordinates(board);
                board.hold.returnFromHold(chosenPiece,coordinatesForChosenPiece);
                colorToMove = colorToMove.opposite();
            }else {
                Move move = InputCoordinates.inputMove(board,colorToMove,mapRenderer);
                board.createMove(move);
                colorToMove = colorToMove.opposite();
                state = determineGameState(board,colorToMove);

                }
            }
        mapRenderer.render(board);
        System.out.println("Game Ended with state: " + state);
        }

    private GameState determineGameState(Board board, Color color) {
        for (GameStateChecker checker : gameStateCheckerList) {
            GameState state = checker.check(board,color);
            if(state != GameState.ONGOING){
                return state;
            }
        }
        return GameState.ONGOING;
    }


    public boolean playerWantToReturnPieceFromHold(Color color){
        if(board.hold.isHoldEmptyForColor(color)){
            return false;
        }
        while (true) {
            System.out.println("Do you want a piece to return from hold? Y/N");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.length() > 1) {
                continue;
            }
            if (answer.equals("Y")){
                return true;
            }else if(answer.equals("N")){
                return false;
            }else {
                continue;
            }
        }
    }
    public Piece playerChosenPieceFromHold(Color color){
        while (true){
            System.out.println("Write the name of the piece you want to return from Hold");
            String answer = scanner.nextLine().toUpperCase();
            if(answer.length() != 1){
                continue;
            }
            ArrayList<Piece> piecesInHold = board.hold.piecesInHold(color);
            for (int i = 0; i < piecesInHold.size();i++){
                Piece currentPiece = piecesInHold.get(i);
                if(currentPiece.getName().equals(answer)){
                    return currentPiece;
                }
            }

        }
    }
}
