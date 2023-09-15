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
                Hold hold = Hold.getUniqueHold();
                hold.displayPiecesInHold(colorToMove);
                Piece chosenPiece = playerChosenPieceFromHold(colorToMove);
                Coordinates coordinatesForChosenPiece = InputCoordinates.inputReturnedPieceCoordinates(board);
                hold.returnFromHold(chosenPiece,coordinatesForChosenPiece);
                colorToMove = colorToMove.opposite();
            }else {
                Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                        colorToMove, board);
                Piece chosenPiece = board.getPiece(sourceCoordinates);
                Coordinates targetCoordinates = InputCoordinates.targetCoordinatesApproval(
                        chosenPiece, sourceCoordinates, board);
                chosenPiece.move(sourceCoordinates, targetCoordinates, board);
                chosenPiece = board.getPiece(targetCoordinates);
                if(chosenPiece.isPieceInPromotionZone(targetCoordinates,chosenPiece)){
                    chosenPiece.promotePiece(chosenPiece);
                }
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
        Hold hold = Hold.getUniqueHold();
        if(hold.isHoldEmptyForColor(color)){
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
            Hold hold =Hold.getUniqueHold();
            ArrayList<Piece> piecesInHold = hold.piecesInHold(color);
            for (int i = 0; i < piecesInHold.size();i++){
                Piece currentPiece = piecesInHold.get(i);
                if(currentPiece.getName().equals(answer)){
                    return currentPiece;
                }
            }

        }
    }
}
