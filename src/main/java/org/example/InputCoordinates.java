package org.example;

import org.example.Piece.Piece;

import java.util.Scanner;

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

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("enter coordinates for piece to move");
            Coordinates coordinates = input();
            if (board.containsPiece(coordinates) == false) {
                System.out.println("the cell is empty");
                continue;
            }
            Piece piece = board.getPiece(coordinates);
            if (piece.color != color) {
                System.out.println("wrong color chosen");
            }
            return coordinates;
        }
    }

    public static Coordinates targetCoordinatesApproval(Piece piece, Coordinates sourceCoordinates, Board board) {
        while (true) {
            System.out.println("enter coordinates to move");
            Coordinates targetCoordinates = input();
            if (piece.isNotOutOfBounds(sourceCoordinates) &&
                    piece.isMoveSatisfyLimit(sourceCoordinates, targetCoordinates) &&
                    piece.isPathAvailable(board, sourceCoordinates, targetCoordinates)) {
                return targetCoordinates;
            }else {
                System.out.println("invalid target coordinates");
                continue;
            }
        }
    }
}
