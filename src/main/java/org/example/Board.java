package org.example;

import org.example.Piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Board {
    private HashMap<Coordinates, Piece> board = new HashMap();

    private List<Piece> hold = new ArrayList<>();
    public void setDefaultPositions(){
        //set Pawns
        for(int i = 0; i < 9; i++){
            setPiece(new Coordinates(2,i),new Pawn(Color.WHITE,new Coordinates(2,i)));
            setPiece(new Coordinates(6,i),new Pawn(Color.BLACK,new Coordinates(7,i)));
        }
        //set Lances
        setPiece(new Coordinates(0,0),new Lance(Color.WHITE,new Coordinates(0,0)));
        setPiece(new Coordinates(0,8),new Lance(Color.WHITE,new Coordinates(0,8)));
        setPiece(new Coordinates(8,0),new Lance(Color.BLACK,new Coordinates(8,0)));
        setPiece(new Coordinates(8,8),new Lance(Color.BLACK,new Coordinates(8,8)));

        //set Knights

        setPiece(new Coordinates(0,1),new Knights(Color.WHITE,new Coordinates(0,1)));
        setPiece(new Coordinates(0,7),new Knights(Color.WHITE,new Coordinates(0,7)));
        setPiece(new Coordinates(8,1),new Knights(Color.BLACK,new Coordinates(8,1)));
        setPiece(new Coordinates(8,7),new Knights(Color.BLACK,new Coordinates(8,7)));


        //set Silver Generals

        setPiece(new Coordinates(0,2),new SilverGeneral(Color.WHITE,new Coordinates(0,2)));
        setPiece(new Coordinates(0,6),new SilverGeneral(Color.WHITE,new Coordinates(0,6)));
        setPiece(new Coordinates(8,2),new SilverGeneral(Color.BLACK,new Coordinates(8,2)));
        setPiece(new Coordinates(8,6),new SilverGeneral(Color.BLACK,new Coordinates(8,6)));

        //set Golden Generals
        setPiece(new Coordinates(0,3),new GoldenGeneral(Color.WHITE,new Coordinates(0,3)));
        setPiece(new Coordinates(0,5),new GoldenGeneral(Color.WHITE,new Coordinates(0,5)));
        setPiece(new Coordinates(8,3),new GoldenGeneral(Color.BLACK,new Coordinates(8,3)));
        setPiece(new Coordinates(8,5),new GoldenGeneral(Color.BLACK,new Coordinates(8,5)));

        //set King
        setPiece(new Coordinates(0,4),new King(Color.WHITE,new Coordinates(0,4)));
        setPiece(new Coordinates(8,4),new King(Color.BLACK,new Coordinates(8,4)));

        //set Rook
        setPiece(new Coordinates(1,7),new Rook(Color.WHITE,new Coordinates(1,7)));
        setPiece(new Coordinates(7,7),new Rook(Color.BLACK,new Coordinates(7,7)));

        //set Bishop
        setPiece(new Coordinates(1,1),new Bishop(Color.WHITE,new Coordinates(1,1)));
        setPiece(new Coordinates(7,1),new Bishop(Color.BLACK,new Coordinates(7,1)));



    }



    public void setPiece(Coordinates coordinates,Piece piece){
        piece.coordinates = coordinates;
        board.put(coordinates,piece);
    }
    public boolean containsPiece(Coordinates coordinates){
        if(board.containsKey(coordinates)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isEnemy(Coordinates from,Coordinates to){
        Piece pieceFrom = getPiece(from);
        Piece pieceTo = getPiece(to);
        if(pieceFrom.color != pieceTo.color){
            return true;
        }else{
            return false;
        }
    }
    public void putInHold(Piece piece){
        hold.add(piece);
    }

    public void deletePiece(Coordinates coordinates){
        board.remove(coordinates);
    }
    public Piece getPiece(Coordinates coordinates){
        try {
            return board.get(coordinates);
        }catch (Exception e){
            throw new RuntimeException("There is no piece on given coordinates");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(this.board, board.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board);
    }
}
