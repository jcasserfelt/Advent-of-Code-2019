package day4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day4s {
    String startString = "231832";
    String endString = "767346";
    String testStart = "387638";
    String testEnd = "919123";

    public static void main(String[] args) throws IOException {
        File file = new File("src\\day4\\testInput.txt");
        List<String> testInputList = new ArrayList<>();
        List<String> listOfOverFlow = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String temp;
        int testCounter = 0;
        while ((temp = reader.readLine()) != null) {
            testCounter++;
            testInputList.add(temp);
        }

        List<String> passwordList = new ArrayList<>();
        String tempString;
        int counter = 0;

        for (int i = 387638; i < 919123; i++) {
            tempString = String.valueOf(i);
            if (isDecreasing(tempString)) {
                if (hasDoublettes(tempString)) {
                    counter++;
                    passwordList.add(tempString);
                }
            }
        }
        for (String s1 : passwordList) {
            boolean found = false;
            for (String s2 : testInputList) {
                //System.out.println(s2);
                if (s1.equals(s2)) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                listOfOverFlow.add(s1);
            }
        }


        System.out.println(counter);
    }

    public static boolean isDecreasing(String input) {


        boolean result = true;
        int tempInt1;
        int tempInt2;
        int j;
        for (int i = 0; i < input.length() - 1; i++) {
            j = i + 1;
            tempInt1 = Integer.parseInt(input.substring(i, i + 1));
            tempInt2 = Integer.parseInt(input.substring(j, j + 1));
            if (tempInt1 > tempInt2) return false;
        }
        return result;
    }

    public static boolean hasDoublettes(String input) {
        List<String> parList = new ArrayList<>();
        int tempInt1;
        int tempInt2;
        int doubleCounter = 0;
        String tempPar = "";
        int j;
        for (int i = 0; i < input.length() - 1; i++) {
            j = i + 1;
            tempInt1 = Integer.parseInt(input.substring(i, i + 1));
            tempInt2 = Integer.parseInt(input.substring(j, j + 1));
            if (tempInt1 == tempInt2) {
                tempPar = String.valueOf(tempInt1) + String.valueOf(tempInt2);
                parList.add(tempPar);
            }
        }
        for (String s : parList) {
            for (int k = 0; k < parList.size(); k++) {
                if (s.equals(parList.get(k))) doubleCounter++;
            }
            if (doubleCounter == 1) return true;
            doubleCounter = 0;
        }
        return false;
    }
}