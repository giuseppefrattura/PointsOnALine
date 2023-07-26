package com.giuseppefrattura.PointsOnaLine.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Point implements Comparable<Point> {

    Double offset;


    public Point(double offset){
        System.err.println("right constructor");
        this.offset=offset;
    }
    public Point(String a , Double offset){
        System.err.println("wrong constructor");
        this.offset=offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(offset, point.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset);
    }

    @Override
    public String toString() {
        return "{" +
                "offset=" + offset +
                "} ";
    }

    @Override
    public int compareTo(Point o) {
        if (this == o) return 0;
        if (o == null) return -1;
        return Double.compare(this.offset, o.offset);
    }

}
