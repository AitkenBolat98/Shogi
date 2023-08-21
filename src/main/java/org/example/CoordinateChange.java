package org.example;

public class CoordinateChange {

    public Integer differenceInCoordinatesHorizontal(Coordinates from,Coordinates to){
        return to.horizontal - from.horizontal;
    }

    public Integer differenceInCoordinatesVertical(Coordinates from,Coordinates to){
        return to.vertical - from.vertical;
    }
}
