package org.example;

public class Game {
    private boolean isWhite = false;
    private final Board board;
    private MapRenderer mapRenderer;

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop(){
        while (true){
            mapRenderer.render(board);
            Coordinates sourceCoordinates = InputCoordinates.
        }
    }
}
