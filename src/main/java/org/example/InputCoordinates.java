package org.example;

import java.util.Scanner;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){
        while (true){
            System.out.println("Input Coordinates EX:11");
            String input = scanner.nextLine();
            if(input.length() != 2){
                System.out.println("Invalid format");
                continue;
            }
            char verticalChar = input.charAt(0);
            char horizontalChar = input.charAt(1);

            if(!Character.isDigit(verticalChar) || !Character.isDigit(horizontalChar)){
                System.out.println("Input is not digit");
                continue;
            }
            int vertical = Character.getNumericValue(verticalChar);
            int horizontal = Character.getNumericValue(horizontalChar);

            if(vertical < 0 || vertical > 8){
                System.out.println("Input is out of bounds");
                continue;
            }
            if(horizontal < 0 || horizontal > 8){
                System.out.println("Input is out of bounds");
                continue;
            }
            return new Coordinates(vertical,horizontal);
        }


    }
}
