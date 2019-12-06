package day2.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2part2 {

    public static void addToLists(List<Integer> testList, List<Integer> testList2, List<Integer> testList3) {
        testList.add(1);
        testList.add(0);
        testList.add(0);
        testList.add(0);
        testList.add(99);

        testList2.add(2);
        testList2.add(3);
        testList2.add(0);
        testList2.add(3);
        testList2.add(1);

        testList3.add(1);
        testList3.add(1);
        testList3.add(1);
        testList3.add(4);
        testList3.add(99);
        testList3.add(5);
        testList3.add(6);
        testList3.add(0);
        testList3.add(99);
    }

    public static void setToOrginalList(String[] stringArray, List<Integer> list) {
        for (int i = 0; i < stringArray.length; i++) {
            list.set(i, Integer.valueOf(stringArray[i]));
            //System.out.print(Integer.valueOf(stringArray[i]) + ", ");
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("input/day2input1.txt");

        // Get som lista going
        List<Integer> inputList = new ArrayList<>();
        List<Integer> inputListOrginale = new ArrayList<>();
        List<Integer> testList = new ArrayList<>();
        List<Integer> testList2 = new ArrayList<>();
        List<Integer> testList3 = new ArrayList<>();
        List<Integer> testList4 = new ArrayList<>();
        Day2part2.addToLists(testList, testList2, testList3);

        // read the file, put the whole thing in a string
        BufferedReader bufIn = new BufferedReader(new FileReader(file));
        String inputString;
        inputString = bufIn.readLine();

        // convert the string to list of integers
        String[] stringArray;
        stringArray = inputString.split(",");

        for (int i = 0; i < stringArray.length; i++) {
            inputList.add(Integer.valueOf(stringArray[i]));
            //System.out.print(Integer.valueOf(stringArray[i]) + ", ");
        }
        // alter the list accord to instructions


        // make copy of original list
        Day2part2.setToOrginalList(stringArray, inputList);


        int iValue = 0;
        int input1 = 0;
        int input2 = 0;
        int resultPosition = 0;
        int operationResult;
        int currentOpcode = 0;
        int magicNumber = 0;
        boolean numberFound = false;


        // total missär
        while (true) {
            if (numberFound == true) break;
            iValue = 0;
            outer:
            for (int i = 0; i <= 99; i++) {
                if (numberFound == true) break;
                iValue = 0;
                for (int j = 0; j <= 99; j++) {

                    inputList.set(1, i);
                    inputList.set(2, j);
                    if (iValue >= inputList.size()) {
                        iValue = 0;
                        //break outer;
                    }
                    currentOpcode = inputList.get(iValue);

                    if (iValue < inputList.size() - 3) {
                        input1 = inputList.get(inputList.get(iValue + 1));
                        input2 = inputList.get(inputList.get(iValue + 2));
                        resultPosition = inputList.get(iValue + 3);
                    }

                    if (currentOpcode == 1) {
                        operationResult = input1 + input2;
                        inputList.set(resultPosition, operationResult);
                    }
                    if (currentOpcode == 2) {
                        operationResult = input1 * input2;
                        inputList.set(resultPosition, operationResult);
                    }
                    if (currentOpcode == 99) {
                        System.out.println("opcode was99");
                        System.out.println("i:" + i + " " + "j:" + j);
                        //System.out.println(inputList);
                        //.out.println("0th value: " + inputList.get(0));
                        //System.out.println("inputListOrginale:" + );
                        //break;
                    }

                    if (currentOpcode != 1 && currentOpcode != 2 && currentOpcode != 99) {
                        System.out.println("wrong opcode" + i + " " + j);
                        break outer;
                        //break;
                    }
                    if (inputList.get(0) == 19690720) {
                        System.out.println("bingo, answer: " + i + " " + j);
                        magicNumber = inputList.get(0);
                        numberFound = true;
                        //break outer;
                    }
                    Day2part2.setToOrginalList(stringArray, inputList);
                    iValue = iValue + 4;


                }
            }
            break;
        }
        System.out.println("magic number" + magicNumber);
    }
}


//tempChar=inputString.charAt(i);
//tempInt=Character.getNumericValue(tempChar);
//inputList.add(tempInt);
