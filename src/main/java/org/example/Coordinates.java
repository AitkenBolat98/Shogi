package org.example;

import java.util.Objects;

public class Coordinates {

    public final Integer vertical;
    public final Integer horizontal;
    public Coordinates(Integer vertical,Integer horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
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
