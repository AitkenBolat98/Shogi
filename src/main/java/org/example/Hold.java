package org.example;

import org.example.Piece.Piece;

import java.util.ArrayList;

public class Hold {
    public final Board board;
    public Hold(Board board){
        this.board = board;
    };


    private ArrayList<Piece> hold = new ArrayList<>();

    public void addToHold(Piece piece){
        hold.add(piece);
    }

    public void returnFromHold(Piece piece,Coordinates coordinates){
        for(int i = 0; i < hold.size();i++){
            if(hold.get(i) == piece){
                board.setPiece(coordinates,piece);
                hold.remove(piece);
                }
                }

    }
    public boolean isPieceInHold(Piece piece){
        if(hold.contains(piece)){
            return true;
        }
        return false;
    }
    public void displayPiecesInHold(Color color){
        for(int i = 0;i < hold.size(); i++){
            if(hold.get(i).getColor() != color){
                System.out.println(hold.get(i).getName());
            }
        }
    }
    public ArrayList<Piece> piecesInHold(Color color){
        ArrayList<Piece> result = new ArrayList<>();
        for(int i = 0;i < hold.size(); i++){
            Piece piece = hold.get(i);
            if(piece.getColor() != color){
                result.add(piece);
            }
        }
        return result;
    }
    public boolean isHoldEmptyForColor(Color color){

        System.out.println("Overall hold size " + hold.size());
        for (int i = 0;i < hold.size();i++){
            if(hold.get(i).getColor() != color){
                return false;
            }
        }
        return true;
    }
}
