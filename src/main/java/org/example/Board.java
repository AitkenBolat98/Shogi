package org.example;

import org.example.Piece.*;

import java.util.*;

public class Board {

    private HashMap<Coordinates, Piece> board = new HashMap();
    public List<Move> moves = new ArrayList<>();
    public final Hold hold = new Hold(this);
    public Board(){};
    public Board makeCopy(Board originalBoard){
        Board clone = new Board();
        clone.setDefaultPositions();
        for(Move move:originalBoard.moves){
            clone.createMove(move);
        }
        return clone;
    }
    public void setDefaultPositions(){
        //set Pawns
        for(int i = 0; i < 9; i++){
/*
            setPiece(new Coordinates(2,i),new Pawn(Color.WHITE,new Coordinates(2,i)));
*/
/*
            setPiece(new Coordinates(6,i),new Pawn(Color.BLACK,new Coordinates(7,i)));
*/
        }
        //set Lances
        /*setPiece(new Coordinates(0,0),new Lance(Color.WHITE,new Coordinates(0,0)));
        setPiece(new Coordinates(0,8),new Lance(Color.WHITE,new Coordinates(0,8)));*/
        setPiece(new Coordinates(8,0),new Lance(Color.BLACK,new Coordinates(8,0)));
        setPiece(new Coordinates(8,8),new Lance(Color.BLACK,new Coordinates(8,8)));

        //set Knights

        /*setPiece(new Coordinates(0,1),new Knights(Color.WHITE,new Coordinates(0,1)));
        setPiece(new Coordinates(0,7),new Knights(Color.WHITE,new Coordinates(0,7)));*/
        setPiece(new Coordinates(8,1),new Knights(Color.BLACK,new Coordinates(8,1)));
        setPiece(new Coordinates(8,7),new Knights(Color.BLACK,new Coordinates(8,7)));


        //set Silver Generals

       /* setPiece(new Coordinates(0,2),new SilverGeneral(Color.WHITE,new Coordinates(0,2)));
        setPiece(new Coordinates(0,6),new SilverGeneral(Color.WHITE,new Coordinates(0,6)));*/
        setPiece(new Coordinates(8,2),new SilverGeneral(Color.BLACK,new Coordinates(8,2)));
        setPiece(new Coordinates(8,6),new SilverGeneral(Color.BLACK,new Coordinates(8,6)));

        //set Golden Generals
       /* setPiece(new Coordinates(0,3),new GoldenGeneral(Color.WHITE,new Coordinates(0,3)));
        setPiece(new Coordinates(0,5),new GoldenGeneral(Color.WHITE,new Coordinates(0,5)));*/
        setPiece(new Coordinates(8,3),new GoldenGeneral(Color.BLACK,new Coordinates(8,3)));
        setPiece(new Coordinates(8,5),new GoldenGeneral(Color.BLACK,new Coordinates(8,5)));

        //set King
        setPiece(new Coordinates(0,4),new King(Color.WHITE,new Coordinates(0,4)));
        setPiece(new Coordinates(8,4),new King(Color.BLACK,new Coordinates(8,4)));

        //set Rook
        //setPiece(new Coordinates(1,7),new Rook(Color.WHITE,new Coordinates(1,7)));
        setPiece(new Coordinates(7,7),new Rook(Color.BLACK,new Coordinates(7,7)));

        //set Bishop
        //setPiece(new Coordinates(1,1),new Bishop(Color.WHITE,new Coordinates(1,1)));
        setPiece(new Coordinates(7,1),new Bishop(Color.BLACK,new Coordinates(7,1)));



    }



    public void setPiece(Coordinates coordinates,Piece piece){
        piece.setCoordinates(coordinates);
        board.put(coordinates,piece);
    }
    public boolean containsPiece(Coordinates coordinates){
        if(board.containsKey(coordinates)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isCellOccupiedByEnemy(Coordinates coordinates,Color color){
        Piece piece = getPiece(coordinates);
        if(piece.getColor() != color){
            return true;
        }
        return false;
    }
    public void createMove(Move move){
        Piece from = board.get(move.from);
        removePiece(move.from);
        setPiece(move.to,from);
        moves.add(move);
    }
    public void removePiece(Coordinates coordinates){
        board.remove(coordinates);
    }

    public List<Piece> getPiecesByColor(Color color){
        List<Piece> result = new ArrayList<>();
        for (Piece piece:board.values()){
            if(piece.getColor() == color){
                result.add(piece);
            }
        }
        return result;
    }
    public void putInHold(Piece piece){
        hold.addToHold(piece);
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
    public boolean isCellAttackedByColor(Color color,Coordinates coordinates){
        List<Piece> enemyPieces = getPiecesByColor(color);

        for(Piece piece:enemyPieces){
            Set<Coordinates> availableAttacksForPiece = piece.getAttackedCells(this);
            if(availableAttacksForPiece.contains(coordinates)){
                return true;
            }
        }

        return false;

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
