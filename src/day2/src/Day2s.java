import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2s {

    public static void main(String[] args) throws IOException {
        File file = new File("input/day2input1.txt");
        List<Integer> inputList = new ArrayList<>();
        // List<Integer> resultList = new ArrayList<>();
        List<Integer> testList = new ArrayList<>();
        List<Integer> testList2 = new ArrayList<>();
        List<Integer> testList3 = new ArrayList<>();
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

        // testList.add(100756);

        //BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader bufIn = new BufferedReader(new FileReader(file));
        //Scanner sc = new Scanner(new FileReader(file));

        String inputString;
        inputString = bufIn.readLine();
        char tempChar;
        int tempInt;
        String tempString;
//      System.out.print(" ");
        String[] stringArray;
        stringArray = inputString.split(",");
        for (int i = 0; i < stringArray.length; i++) {
            inputList.add(Integer.valueOf(stringArray[i]));
            //System.out.print(Integer.valueOf(stringArray[i]) + ", ");
        }
//      System.out.println();
//      System.out.println(inputList);
//        System.out.println(testList);
//        System.out.println(testList2);
//        System.out.println(testList3);

        int magicNumber = 0;
        int magicI = 0;
        int magicJ = 0;
        int finalAnswer = 0;
        outer:
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = 0; j < inputList.size(); j++) {

                inputList.clear();
                for (int k = 0; k < stringArray.length; k++) {
                    inputList.add(Integer.valueOf(stringArray[k]));
                    //System.out.print(Integer.valueOf(stringArray[i]) + ", ");
                }

                inputList.set(1, i);
                inputList.set(2, j);

                int iValue = 0;
                int input1 = 0;
                int input2 = 0;
                int resultPosition = 0;
                int operationResult = 0;
                int currentOpcode;

                while (iValue <= inputList.size()) {
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
//                        System.out.println("opcode was99");
//                        System.out.println(inputList);
//                        System.out.println("0th value: " + inputList.get(0));
                        break;
                    }

                    if (currentOpcode != 1 && currentOpcode != 2 && currentOpcode != 99) {
//                        System.out.println("wrong opcode");
                        break;
                    }
                    if (inputList.get(0) == 19690720) {
                        System.out.println("bingo, answer: " + i + " " + j);
                        magicNumber = inputList.get(0);
                        magicI = i;
                        magicJ = j;
                        finalAnswer = (100 * i) + j;
                        break outer;

//                        numberFound = true;
                        //break outer;
                    }
                    iValue = iValue + 4;
                }
            }
        }
        System.out.println("magicNumber: " + magicNumber);
        System.out.println("magicI: " + magicI);
        System.out.println("magicJ: " + magicJ);
        System.out.println("finalAnswer: " + finalAnswer);
    }
}

//tempChar=inputString.charAt(i);
//tempInt=Character.getNumericValue(tempChar);
//inputList.add(tempInt);
/*
100*70 + 14
7014
 */
