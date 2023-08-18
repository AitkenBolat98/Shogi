package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        MapRenderer mapRenderer = new MapRenderer();
        board.setDefaultPositions();
        mapRenderer.render(board);
    }

}