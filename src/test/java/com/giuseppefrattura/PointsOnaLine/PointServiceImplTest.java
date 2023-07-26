package com.giuseppefrattura.PointsOnaLine;

import com.giuseppefrattura.PointsOnaLine.model.Point;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class PointServiceImplTest {

    @Test
    void neighbours(){
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        Point p1 = new Point(-1);
        Point p2 = new Point(5);
        Point p3 = new Point(2.5);
        Point p4 = new Point(5.1);
        Point p5 = new Point(3);
        Point p6 = new Point(3.4);
        Point p7 = new Point(3.6);
        Point p8 = new Point(7);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);
        pc.addPoint(p4);
        pc.addPoint(p5);
        pc.addPoint(p6);
        pc.addPoint(p7);
        pc.addPoint(p8);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();

        Set<Point> neighbours = pi.getNeighbours(points, 3, 3);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p3);
        expectedneighbours.add(p6);
        expectedneighbours.add(p5);

        assertEquals(expectedneighbours, neighbours);
    }

    @Test
    void neighboursExamples() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        double target = 3;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();

        Set<Point> neighbours = pi.getNeighbours(points, target, 0);

        Set<Point> expectedNeighbours = new TreeSet<>();

        assertEquals(expectedNeighbours, neighbours);
        assertEquals("[]", neighbours.toString());
    }

    @Test
    void neighboursExamples1() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        double target = 3;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();

        Set<Point> neighbours = pi.getNeighbours(points, target, 1);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p2);

        assertEquals(expectedneighbours, neighbours);

    }

    @Test
    void neighboursExamples2() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        pc.deleteAllPoints();

        double target = 3;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();

        Set<Point> neighbours = pi.getNeighbours(points, target, 2);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p2);
        expectedneighbours.add(p3);

        assertEquals(expectedneighbours, neighbours);
    }

    @Test
    void neighboursExamples3() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        double target = 4;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();

        Set<Point> neighbours = pi.getNeighbours(points, target, 2);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p2);
        expectedneighbours.add(p3);

        assertEquals(expectedneighbours, neighbours);

    }

    @Test
    void neighboursExamples4() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        double target = 3.5;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();


        Set<Point> neighbours = pi.getNeighbours(points, target, 1);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p2);

        assertEquals(expectedneighbours, neighbours);

    }

    @Test
    void neighboursExamples5() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        double target = 3.5;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();


        Set<Point> neighbours = pi.getNeighbours(points, target, 2);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p2);
        expectedneighbours.add(p3);

        assertEquals(expectedneighbours, neighbours);


    }

    @Test
    void neighboursExamples6() {
        PointController pc = new PointController();
        PointServiceImpl pi = new PointServiceImpl();

        double target = 0;

        Point p1 = new Point(1);
        Point p2 = new Point(3);
        Point p3 = new Point(4);

        pc.addPoint(p1);
        pc.addPoint(p2);
        pc.addPoint(p3);

        TreeSet<Point> points = (TreeSet<Point>) pc.getPoints(PointController.orderType.ASC).getBody();


        Set<Point> neighbours = pi.getNeighbours(points, target, 100);

        Set<Point> expectedneighbours = new TreeSet<>();
        expectedneighbours.add(p2);
        expectedneighbours.add(p3);
        expectedneighbours.add(p1);

        assertEquals(expectedneighbours, neighbours);
    }

}