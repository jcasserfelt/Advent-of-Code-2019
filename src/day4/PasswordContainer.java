package day4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PasswordContainer {
    private static ArrayDeque<Object> passwordList;
    String startString = "231832";
    String endString = "767346";
    //1085
    //673 too low
    // 894
    // ska vara runt 860

    public static void main(String[] args) {
        List<String> passwordList = new ArrayList<>();
        String tempString;
        int counter = 0;

        for (int i = 231832 ; i < 767346; i++) {
            tempString = String.valueOf(i);
            if (isDecreasing(tempString) && hasDoublettes2(tempString)) {
                counter++;
                passwordList.add(tempString);
            }
        }
        System.out.println("Antal möjligheter: " + counter);
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
        boolean result = false;
        int tempInt1;
        int tempInt2;
        int j;
        for (int i = 0; i < input.length() - 1; i++) {
            j = i + 1;
            tempInt1 = Integer.parseInt(input.substring(i, i + 1));
            tempInt2 = Integer.parseInt(input.substring(j, j + 1));
            if (tempInt1 == tempInt2) return true;
        }
        return result;
    }

    public static boolean hasDoublettes2(String input) {
        boolean result = true;
        int tempInt1;
        int tempInt2;
        int doubleCounter = 0;
        String tempdouble = "";
        int j;
        for (int i = 0; i < input.length() - 1; i++) {
            j = i + 1;
            tempInt1 = Integer.parseInt(input.substring(i, i + 1));
            tempInt2 = Integer.parseInt(input.substring(j, j + 1));
            if (tempInt1 == tempInt2) {
                doubleCounter++;
                if (tempdouble.equals("")) {
                    tempdouble += String.valueOf(tempInt1) + String.valueOf(tempInt2);
                } else {
                    tempdouble += String.valueOf(tempInt1);
                }
            } else {
                if(tempdouble.length() > 0 && tempdouble.length()%2 != 0) {
                    return false;}
                else tempdouble = "";
            }
        }
        if (tempdouble.length() % 2 != 0) return false;
        return result;
    }
}

