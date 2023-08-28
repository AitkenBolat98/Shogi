package org.example;

public class MapRenderer {
    private static MapRenderer uniqueMapRenderer;

    private MapRenderer(){}

    public static MapRenderer getUniqueMapRenderer(){
        if(uniqueMapRenderer == null){
            uniqueMapRenderer = new MapRenderer();
        }
        return uniqueMapRenderer;
    }
    public void render(Board board){
        System.out.print(" |");
        for (int i = 0; i < 9; i++) {
            System.out.print( " " + i + " |");
        }
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 9; j++) {
                Coordinates coordinates = new Coordinates(i,j);
                if (board.containsPiece(coordinates)) {
                    System.out.print(" " + board.getPiece(coordinates).getName() + " |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
        }
        System.out.println("__________________________________________");
    }
    }

