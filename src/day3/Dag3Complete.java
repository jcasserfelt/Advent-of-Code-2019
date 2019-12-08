package day3;

import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dag3Complete {

    public static void main(String[] args) throws IOException {
        // some useful stuff
        int currentX = 0;
        int currentY = 0;
        int tempX = 0;
        int tempY = 0;
        int closestIntersectionDistance = Integer.MAX_VALUE;
        int manhattanDistance;
        int intersectionCount = 0;
        String[] cable1Array;
        String[] cable2Array;
        String inputString;
        Coordinate[] cable1List;
        Coordinate[] cable2CoordinatesArray;

        File file = new File("src\\day3\\Input\\day3input1_1.txt");
        BufferedReader bufIn = new BufferedReader(new FileReader(file));
        List<Coordinate> cable1CoordinationPath = new ArrayList<>();
        List<Coordinate> cable2CoordinationPath = new ArrayList<>();
        List<Coordinate> intersections = new ArrayList<>();
        // put input data in string arrays
        inputString = bufIn.readLine();
        cable1Array = inputString.split(",");

        inputString = bufIn.readLine();
        cable2Array = inputString.split(",");
        cable2CoordinatesArray = new Coordinate[cable2Array.length];

        // unwind cable 1
        for (int i = 0; i < cable1Array.length; i++) {
            if (cable1Array[i].charAt(0) == 'R') {
                tempX = currentX;
                currentX += Integer.parseInt(cable1Array[i].substring(1));
                for (int j = 0; j < Integer.parseInt(cable1Array[i].substring(1)); j++) {
                    tempX++;
                    cable1CoordinationPath.add(new Coordinate(tempX, currentY));
                }
            }
            if (cable1Array[i].charAt(0) == 'L') {
                tempX = currentX;
                currentX -= Integer.parseInt(cable1Array[i].substring(1));
                for (int j = 0; j < Math.abs(Integer.parseInt(cable1Array[i].substring(1))); j++) {
                    tempX--;
                    cable1CoordinationPath.add(new Coordinate(tempX, currentY));
                }
            }
            if (cable1Array[i].charAt(0) == 'U') {
                tempY = currentY;
                currentY += Integer.parseInt(cable1Array[i].substring(1));
                for (int j = 0; j < Math.abs(Integer.parseInt(cable1Array[i].substring(1))); j++) {
                    tempY++;
                    cable1CoordinationPath.add(new Coordinate(currentX, tempY));
                }
            }
            if (cable1Array[i].charAt(0) == 'D') {
                tempY = currentY;
                currentY -= Integer.parseInt(cable1Array[i].substring(1));
                for (int j = 0; j < Math.abs(Integer.parseInt(cable1Array[i].substring(1))); j++) {
                    tempY--;
                    cable1CoordinationPath.add(new Coordinate(currentX, tempY));
                }
            }
        }
        // get coordinates for wire2
        currentX = 0;
        currentY = 0;
        tempX = 0;
        tempY = 0;
        for (int i = 0; i < cable2Array.length; i++) {
            if (cable2Array[i].charAt(0) == 'R') {
                tempX = currentX;
                currentX += Integer.parseInt(cable2Array[i].substring(1));
                for (int j = 0; j < Integer.parseInt(cable2Array[i].substring(1)); j++) {
                    tempX++;
                    cable2CoordinationPath.add(new Coordinate(tempX, currentY));
                }
            }
            if (cable2Array[i].charAt(0) == 'L') {
                tempX = currentX;
                currentX -= Integer.parseInt(cable2Array[i].substring(1));
                for (int j = 0; j < Math.abs(Integer.parseInt(cable2Array[i].substring(1))); j++) {
                    tempX--;
                    cable2CoordinationPath.add(new Coordinate(tempX, currentY));
                }
            }
            if (cable2Array[i].charAt(0) == 'U') {
                tempY = currentY;
                currentY += Integer.parseInt(cable2Array[i].substring(1));
                for (int j = 0; j < Math.abs(Integer.parseInt(cable2Array[i].substring(1))); j++) {
                    tempY++;
                    cable2CoordinationPath.add(new Coordinate(currentX, tempY));
                }
            }
            if (cable2Array[i].charAt(0) == 'D') {
                tempY = currentY;
                currentY -= Integer.parseInt(cable2Array[i].substring(1));
                for (int j = 0; j < Math.abs(Integer.parseInt(cable2Array[i].substring(1))); j++) {
                    tempY--;
                    cable2CoordinationPath.add(new Coordinate(currentX, tempY));
                }
            }
        }
        double counter = 0;
        for (Coordinate c1 : cable1CoordinationPath) {
            manhattanDistance = c1.getManhattan();
            for (Coordinate c2 : cable2CoordinationPath) {
                counter++;
                if (c2.xValue == c1.xValue && c2.yValue == c1.yValue) {
                    intersectionCount++;
                    if (c2.getManhattan() < closestIntersectionDistance) {
                        closestIntersectionDistance = c2.getManhattan();
                    }
                    intersections.add(c2);
                }
            }
        }
        System.out.println("counter: " + counter);
        System.out.println("intersectionCount: " + intersectionCount);
        System.out.println("closestIntersectionDistance: " + closestIntersectionDistance);
        int steps1 = 0;
        int steps2 = 0;
        int stepsSum = 0;
        int tempStepSum = 0;
        int shortestStepSum = Integer.MAX_VALUE;
        for (Coordinate c3 : intersections) {
            steps1 = 0;
            steps2 = 0;
            for (Coordinate c1 : cable1CoordinationPath) {
                steps1++;
                if (c1.xValue == c3.xValue && c1.yValue == c3.yValue) {
//                    steps1 ++;
                    break;
                }
            }
            for (Coordinate c2 : cable2CoordinationPath) {
                steps2++;
                if (c2.xValue == c3.xValue && c2.yValue == c3.yValue) {
//                    steps2++;
                    break;
                }
            }
            stepsSum = steps1 + steps2;
            if (stepsSum < shortestStepSum) {
                shortestStepSum = stepsSum;
            }
        }
        System.out.println("shortestStepSum: " + shortestStepSum);
    }
}