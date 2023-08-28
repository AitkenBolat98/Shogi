package org.example;

import org.example.Piece.Piece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Coordinates {

    public final Integer vertical;
    public final Integer horizontal;
    public Coordinates(Integer vertical,Integer horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }
    public HashSet<Coordinates> promotionZone(Piece piece){
        HashSet<Coordinates> result = new HashSet<>();
        if(piece.getColor() == Color.WHITE){
            for(int i = 6;i < 9;i++){
                for (int j = 0;j < 9;j++){
                    Coordinates coordinates = new Coordinates(i,j);
                    result.add(coordinates);
                }
            }
        }else {
            for(int i = 2;i < -1;i--){
                for (int j = 0;j < 9;j++){
                    Coordinates coordinates = new Coordinates(i,j);
                    result.add(coordinates);
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(vertical, that.vertical) && Objects.equals(horizontal, that.horizontal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }
}
