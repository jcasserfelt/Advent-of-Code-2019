package day3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dag3 {

    public static void main(String[] args) throws IOException {
        // some useful stuff
        int currentX = 0;
        int currentY = 0;
        int tempX = 0;
        int tempY = 0;
        int closestIntersectionDistance = Integer.MAX_VALUE;
        int tempIntersection;
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
        // put input data in string arrays
        inputString = bufIn.readLine();
        cable1Array = inputString.split(",");
        cable1List = new Coordinate[cable1Array.length];
        inputString = bufIn.readLine();
        cable2Array = inputString.split(",");
        cable2CoordinatesArray = new Coordinate[cable2Array.length];

        // unwind cable 1
        for (int i = 0; i < cable1Array.length; i++) {
            if (cable1Array[i].charAt(0) == 'R') {
                tempX = currentX;
                currentX += Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                for (int j = 0; j < currentX; j++) {
                    cable1CoordinationPath.add(new Coordinate(tempX, currentY));
                    tempX++;
                }
            }
            if (cable1Array[i].charAt(0) == 'L') {
                tempX = currentX;
                currentX -= Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                for (int j = 0; j > currentX; j--) {
                    cable1CoordinationPath.add(new Coordinate(tempX, currentY));
                    tempX--;
                }
            }
            if (cable1Array[i].charAt(0) == 'U') {
                tempY = currentY;
                currentY += Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                for (int j = 0; j < currentY; j++) {
                    cable1CoordinationPath.add(new Coordinate(currentX, tempY));
                    tempY++;
                }
            }
            if (cable1Array[i].charAt(0) == 'D') {
                tempY = currentY;
                currentY -= Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                for (int j = 0; j > currentY; j--) {
                    cable1CoordinationPath.add(new Coordinate(currentX, tempY));
                    tempY--;
                }
            }
        }
        //System.out.println(cable1Array);


        // Lets go cable 2
        currentX = 0;
        currentY = 0;
        tempX = 0;
        tempY = 0;
        for (int i = 0; i < cable2Array.length; i++) {
            tempX = currentX;
            if (cable2Array[i].charAt(0) == 'R') {
                currentX += Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                for (int j = 0; j < currentX; j++) {
                    cable2CoordinationPath.add(new Coordinate(tempX, currentY));
                    tempX++;
                }
            }
            if (cable2Array[i].charAt(0) == 'L') {
                tempX = currentX;
                currentX -= Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                for (int j = 0; j > currentX; j--) {
                    cable2CoordinationPath.add(new Coordinate(tempX, currentY));
                    tempX--;
                }
            }
            if (cable2Array[i].charAt(0) == 'U') {
                tempY = currentY;
                currentY += Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                for (int j = 0; j < currentY; j++) {
                    cable2CoordinationPath.add(new Coordinate(currentX, tempY));
                    tempY++;
                }
            }
            if (cable2Array[i].charAt(0) == 'D') {
                tempY = currentY;
                currentY -= Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                for (int j = 0; j > currentY; j--) {
                    cable2CoordinationPath.add(new Coordinate(currentX, tempY));
                    tempY--;
                }
            }
        }
        for (Coordinate c1 : cable1CoordinationPath) {
            tempX = c1.xValue;
            tempY = c1.yValue;
            for (Coordinate c2 : cable2CoordinationPath) {
                if (c2.xValue == tempX && c2.yValue == tempY) {
                }
                tempIntersection = Math.abs(tempX) + Math.abs(tempY);
                intersectionCount++;
                if (tempIntersection < closestIntersectionDistance) {
                    closestIntersectionDistance = tempIntersection;
                }
            }
        }


        System.out.println("Kabel1 längd: " + cable1Array.length);
        System.out.println("Kabel2 längd: " + cable2Array.length);
        System.out.println("antal interserktions: " + intersectionCount);
        System.out.println("closestIntersectionDistance: " + closestIntersectionDistance);

    }
}

//        for (int i = 0; i < cable1CoordinatesArray.length ; i++) {
//            tempX = cable1CoordinatesArray[i].xValue;
//            tempY = cable1CoordinatesArray[i].yValue;
//            for (int j = 0; j <cable2CoordinatesArray.length ; j++) {
//                if(cable2CoordinatesArray[j].xValue == tempX && cable2CoordinatesArray[j].yValue == tempY){
//                   tempIntersection = Math.abs(tempX) + Math.abs(tempY);
//                    intersectionCount++;
//                   if (tempIntersection < closestIntersectionDistance) {
//                       closestIntersectionDistance = tempIntersection;
//                   }
//                }
//            }
//        }