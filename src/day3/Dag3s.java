package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dag3s {

    public static void main(String[] args) throws IOException {
        // some useful stuff
        int currentX = 0;
        int currentY = 0;
        int x0 = 0;
        int y0 = 0;
        int closestIntersectionDistance = Integer.MAX_VALUE;
        int tempIntersection;
        int intersectionCount = 0;
        String[] cable1Array;
        String[] cable2Array;
        String inputString;
        Coordinate[] cable1List;
        Coordinate[] cable2CoordinatesArray;

        File file = new File("src/day3/Input/day3input1.txt");
        BufferedReader bufIn = new BufferedReader(new FileReader(file));
        List<Line> linesList1 = new ArrayList<>();
        List<Line> linesList2 = new ArrayList<>();
        List<Coordinate> coordinateList = new ArrayList<>();


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
                x0 = currentX;
                currentX += Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                linesList1.add(new HoLine(x0, currentX, currentY));
            }
            if (cable1Array[i].charAt(0) == 'L') {
                x0 = currentX;
                currentX -= Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                linesList1.add(new HoLine(x0, currentX, currentY));
                ;

            }
            if (cable1Array[i].charAt(0) == 'U') {
                y0 = currentY;
                currentY += Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                linesList1.add(new VertLine(currentX, y0, currentY));

            }
            if (cable1Array[i].charAt(0) == 'D') {
                y0 = currentY;
                currentY -= Integer.parseInt(cable1Array[i].substring(1, cable1Array[i].length()));
                linesList1.add(new VertLine(currentX, y0, currentY));
            }
        }
        //System.out.println(cable1Array);


        // Lets go cable 2
        currentX = 0;
        currentY = 0;
        for (int i = 0; i < cable2Array.length; i++) {
            x0 = currentX;
            if (cable2Array[i].charAt(0) == 'R') {
                currentX += Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                linesList2.add(new HoLine(x0, currentX, currentY));
            }
            if (cable2Array[i].charAt(0) == 'L') {
                x0 = currentX;
                currentX -= Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                linesList2.add(new HoLine(x0, currentX, currentY));
                ;
            }
            if (cable2Array[i].charAt(0) == 'U') {
                y0 = currentY;
                currentY += Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                linesList2.add(new VertLine(currentX, y0, currentY));
            }
            if (cable2Array[i].charAt(0) == 'D') {
                y0 = currentY;
                currentY -= Integer.parseInt(cable2Array[i].substring(1, cable2Array[i].length()));
                linesList2.add(new VertLine(currentX, y0, currentY));
            }
        }


        for (Line l1 : linesList1) {
            for (int i = 0; i < l1.coords.length ; i++) {
                coordinateList.add(l1.coords[i]);
            }

            for (Line l2 : linesList2) {
                for (int i = 0; i < l2.coords.length; i++) {
                    if(l2.coords[i].yValue ==)
                }
            }
        }

        System.out.println("Kabel1 längd: " + cable1Array.length);
        System.out.println("Kabel2 längd: " + cable2Array.length);
        System.out.println("antal interserktions: " + intersectionCount);
        System.out.println("closestIntersectionDistance" + closestIntersectionDistance);
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


//        for (Coordinate c1 : cable1CoordinationPath) {
//            tempX = c1.xValue;
//            tempY = c1.yValue;
//            for (Coordinate c2 : cable2CoordinationPath) {
//                if (c2.xValue == tempX && c2.yValue == tempY) {
//                }
//                tempIntersection = Math.abs(tempX) + Math.abs(tempY);
//                intersectionCount++;
//                if (tempIntersection < closestIntersectionDistance) {
//                    closestIntersectionDistance = tempIntersection;
//                }
//            }
//        }