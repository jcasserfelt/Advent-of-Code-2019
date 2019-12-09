package day4;

import java.util.Arrays;

public class Day4s {
    String startString = "231832";
    String endString = "767346";


    public static void main(String[] args) {
        String tempString;
        int counter = 0;

        for (int i = 123444; i < 767346; i++) {
            tempString = String.valueOf(i);
            if (isDecreasing(tempString)) {
                if (hasDouble2(tempString)) {
                    counter++;
                }
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

    //111122
    public static boolean hasDouble(String input) {
        int tempInt1;
        int tempInt2;
        int tooHigh = 0;
        boolean hasPair = false;
        String tempPar = "";
        String par = "";
        int j = 0;
        char[] array = input.toCharArray();
        for (int i = 0; i < input.length() - 1; i++) {
            if (array[i] == array[i + 1] && i == 4) return true;
            if (array[i] == array[i + 1] && i < 4) {
                if (array[i] == array[i + 2] && i < 3) {
                    if (array[i] == array[i + 3] && i < 2) {
                        if (array[i] == array[i + 4] && i < 1) {
                            if (array[i] == array[i + 5]) {
                            }
                        } else i = 3;
                    } //else i = 3;
                } else hasPair = true;
            }
        }
        return hasPair;
    }
}