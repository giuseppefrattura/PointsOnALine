package com.giuseppefrattura.PointsOnaLine;

import com.giuseppefrattura.PointsOnaLine.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PointController {

    enum orderType{
        DESC,
        ASC
    }

    static TreeSet<Point> points = new TreeSet<>();

    @Autowired
    private PointService pointService;

    @PostMapping("/point")
    public ResponseEntity<Object> addPoint(@RequestBody Point point){
        points.add(point);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/point")
    public ResponseEntity<Set<Point>> getPoints(orderType order){
        if (order==null || order.equals(orderType.ASC))
            return ResponseEntity.ok().body(points);
        else
            return ResponseEntity.ok().body(points.descendingSet());
    }

    @DeleteMapping("/point")
    public ResponseEntity<Object> deleteAllPoints(){
        points.clear();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/neighbours/{point}")
    public ResponseEntity<Set<Point>> getNeighboursPoints(@PathVariable double point, @RequestParam("k") Integer k){

        Set<Point> neighbours = pointService.getNeighbours(points, point, k);
        return ResponseEntity.ok().body(neighbours);
    }

}
