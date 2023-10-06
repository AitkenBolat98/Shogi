package org.example;

import java.util.ArrayList;
import java.util.List;

public class BoardShifts {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates source, Coordinates target) {

        List<Coordinates> result = new ArrayList<>();

        int fileShift = source.vertical < target.vertical ? 1 : -1;
        int rankShift = source.horizontal < target.horizontal ? 1 : -1;

        for (
                int fileIndex = source.vertical + fileShift,
                rank = source.horizontal + rankShift;

                fileIndex != target.vertical && rank != target.horizontal;

                fileIndex += fileShift, rank += rankShift
        ) {
            result.add(new Coordinates(fileIndex, rank));
        }

        return result;
    }

    public static List<Coordinates> getVerticalCoordinatesBetween(Coordinates source, Coordinates target) {

        List<Coordinates> result = new ArrayList<>();

        int rankShift = source.horizontal < target.horizontal ? 1 : -1;

        for (int rank = source.horizontal + rankShift; rank != target.horizontal; rank += rankShift) {
            result.add(new Coordinates(source.vertical, rank));
        }

        return result;
    }

    public static List<Coordinates> getHorizontalCoordinatesBetween(Coordinates source, Coordinates target) {

        List<Coordinates> result = new ArrayList<>();

        int fileShift = source.vertical < target.vertical ? 1 : -1;

        for (
                int fileIndex = source.vertical + fileShift; fileIndex != target.vertical;
                fileIndex += fileShift
        ) {
            result.add(new Coordinates(fileIndex, source.horizontal));
        }

        return result;
    }
}
