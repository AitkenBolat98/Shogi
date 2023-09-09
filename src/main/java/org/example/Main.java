package org.example;

import org.example.Game.Game;

public class Main {
    public static void main(String[] args) {
        Board board = Board.getUniqueBoard();
        board.setDefaultPositions();
        MapRenderer mapRenderer = MapRenderer.getUniqueMapRenderer();
        Game game = new Game(board,mapRenderer);
        game.gameLoop();
    }

}