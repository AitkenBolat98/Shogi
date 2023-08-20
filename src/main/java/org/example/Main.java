package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setDefaultPositions();
        MapRenderer mapRenderer = new MapRenderer();
        Game game = new Game(board,mapRenderer);
        game.gameLoop();
    }

}