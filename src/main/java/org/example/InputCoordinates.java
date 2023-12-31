package org.example;

import org.example.Piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
        while (true) {
            System.out.println("Input Coordinates EX:11");
            String input = scanner.nextLine();
            Integer inputLength = input.length();
            if (inputLength != 2) {
                System.out.println("Invalid format");
                continue;
            }
            char verticalChar = input.charAt(0);
            char horizontalChar = input.charAt(1);

            if (!Character.isDigit(verticalChar) || !Character.isDigit(horizontalChar)) {
                System.out.println("Input is not digit");
                continue;
            }
            int vertical = Character.getNumericValue(verticalChar);
            int horizontal = Character.getNumericValue(horizontalChar);

            if (vertical < 0 || vertical > 8) {
                System.out.println("Input is out of bounds");
                continue;
            }
            if (horizontal < 0 || horizontal > 8) {
                System.out.println("Input is out of bounds");
                continue;
            }
            return new Coordinates(vertical, horizontal);
        }

    }

    public static Coordinates inputReturnedPieceCoordinates(Board board) {
        while (true) {
            Coordinates coordinates = input();
            if (board.containsPiece(coordinates)) {
                continue;
            } else {
                return coordinates;
            }
        }
    }

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("enter coordinates for piece to move");
            Coordinates coordinates = input();
            if (board.containsPiece(coordinates) == false) {
                System.out.println("the cell is empty");
                continue;
            }
            Piece piece = board.getPiece(coordinates);
            if (piece.getColor() != color) {
                System.out.println("wrong color chosen");
                continue;
            }

            Set<Coordinates> availableMovesForChosenPiece = piece.getAvailableMoves(board);
            if (availableMovesForChosenPiece.size() == 0) {
                System.out.println("no available moves");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputAvailableCell(Set<Coordinates> availableCoordinates) {
        while (true) {
            System.out.println("enter coordinates to move");
            Coordinates targetCoordinates = input();
            if(!availableCoordinates.contains(targetCoordinates)){
                continue;
            }
            return targetCoordinates;
        }
    }

    public static Move inputMove(Board board, Color color, MapRenderer renderer) {
        while (true) {
            Coordinates sourceCoordinates = inputPieceCoordinatesForColor(color,board);
            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableCoordinatesForChosenPiece = piece.getAvailableMoves(board);
            Coordinates targetCoordinates = inputAvailableCell(availableCoordinatesForChosenPiece);
            if(piece.isPathOccupiedByFriendly(targetCoordinates,board)){
                System.out.println("path to target coordinates is blocked");
                continue;
            }
            Move move = new Move(sourceCoordinates,targetCoordinates);
            return move;

        }
    }
}