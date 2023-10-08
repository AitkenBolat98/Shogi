package org.example;

import org.example.Piece.Piece;

import java.util.Collections;
import java.util.Set;

public class MapRenderer {
    private static MapRenderer uniqueMapRenderer;

    private MapRenderer() {
    }

    public static MapRenderer getUniqueMapRenderer() {
        if (uniqueMapRenderer == null) {
            uniqueMapRenderer = new MapRenderer();
        }
        return uniqueMapRenderer;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String WHITE_PIECE = "\u001B[97m";
    public static final String BLACK_PIECE = "\u001B[30m";

    public static final String WHITE_BACKGROUND = "\u001B[47m";

    public static final String BLACK_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void doRender(Board board, Piece piece) {
        Set<Coordinates> availableMoves = Collections.emptySet();
        if (piece != null) {
            availableMoves = piece.getAvailableMoves(board);
        }
        for (int vertical = 8; vertical >-1; vertical--) {
            String l = "";
            for (int horizontal = 8; horizontal > -1; horizontal--) {
                Coordinates newCoordinates = new Coordinates(vertical, horizontal);
                boolean isOccupied = availableMoves.contains(newCoordinates);

                if (!board.containsPiece(newCoordinates)) {
                    l += getSpriteForEmptySquare(newCoordinates, isOccupied) + "  ";
                } else {
                    l += getPieceSprite(board.getPiece(newCoordinates), isOccupied);
                }
            }
            l += ANSI_RESET;
            System.out.println(l);
        }
    }

    public void render(Board board) {
        doRender(board, null);
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getName()) {
            case "P":
                return "♟︎";

            case "N":
                return "♞";

            case "B":
                return "♝";

            case "R":
                return "♜";

            case "G":
                return "♛";

            case "K":
                return "♚";

            case "L":
                return "Ⓛ";
            case "S":
                return "Ⓢ";
        }

        return " ";
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighlight) {
        // format = background color + font color + text
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = WHITE_PIECE + result;
        } else {
            result = BLACK_PIECE + result;
        }

        if (isHighlight) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        } else if (isSquareDark) {
            result = BLACK_BACKGROUND + result;
        } else {
            result = WHITE_BACKGROUND + result;
        }

        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlight) {
        return colorizeSprite( "  ", Color.WHITE, Board.isCellBlack(coordinates), isHighlight);
    }

    private String getPieceSprite(Piece piece, boolean isHighlight) {
        return colorizeSprite(
                " " + selectUnicodeSpriteForPiece(piece) + " ", piece.getColor(), Board.isCellBlack(piece.getCoordinates()
                ), isHighlight);
    }
}

