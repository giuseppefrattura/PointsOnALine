package com.giuseppefrattura.PointsOnaLine;

import com.giuseppefrattura.PointsOnaLine.model.Point;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PointServiceImpl implements PointService {

    public Set<Point> getNeighbours(TreeSet<Point> list, double target, Integer k) {

        if (k == null )
            k = 1;

        PriorityQueue<Point> priorityQueue =
                new PriorityQueue<>(Comparator.comparingDouble(a -> {
                    return Math.abs(a.getOffset() - target);
                }));

        priorityQueue.addAll(list);

        Set<Point> nearestNeighbours = new HashSet<>();

        while ((nearestNeighbours.size() < k) && !priorityQueue.isEmpty()) {
            nearestNeighbours.add(priorityQueue.poll());
        }

        return nearestNeighbours;
    }
}
