package com.giuseppefrattura.PointsOnaLine;

import com.giuseppefrattura.PointsOnaLine.model.Point;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PointsOnaLineApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void addNode(){
		PointController pc = new PointController();
		Point p1 = new Point(-1);
		Point p2 = new Point(5);
		Point p3 = new Point(2.5);
		Point p4 = new Point(5);

		pc.addPoint(p1);
		pc.addPoint(p2);
		pc.addPoint(p3);
		pc.addPoint(p4);

		ResponseEntity<Set<Point>> points = pc.getPoints(PointController.orderType.ASC);
		Set<Point> body = points.getBody();

		assertEquals(3, points.getBody().size());

		Set<Point> expectedBody = new TreeSet<>();
		expectedBody.add(p1);
		expectedBody.add(p3);
		expectedBody.add(p2);

		assertEquals(body.toString(),expectedBody.toString());

		ResponseEntity<Set<Point>> descPoints = pc.getPoints(PointController.orderType.DESC);

		Set<Point> expectedDescBody = new TreeSet<>();
		expectedDescBody.add(p2);
		expectedDescBody.add(p3);
		expectedDescBody.add(p1);

		String expectedString= "[" + p2 + ", " + p3 +  ", " + p1 + "]";

		assertNotEquals(expectedBody.toString(), descPoints.getBody().toString());
		assertEquals(expectedString, descPoints.getBody().toString());

	}





}
