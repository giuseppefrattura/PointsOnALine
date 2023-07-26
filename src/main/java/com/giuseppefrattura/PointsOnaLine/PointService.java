package com.giuseppefrattura.PointsOnaLine;

import com.giuseppefrattura.PointsOnaLine.model.Point;

import java.util.Set;
import java.util.TreeSet;

public interface PointService {
    Set<Point> getNeighbours(TreeSet<Point> list, double target, Integer k);
}
