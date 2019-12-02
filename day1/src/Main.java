import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        File file = new File("day1/input/input.txt");
        List<Integer> inputList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        List<Integer> testList = new ArrayList<>();
        testList.add(100756);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (true) {
            String temp;
            temp = reader.readLine();
            if (temp == null) break;
            else inputList.add(Integer.parseInt(temp));
        }
        //System.out.println(inputList);
        int resultSum = 0;
        int modulemadness = 0;
        for (Integer i : inputList) {
            int temp = i;
            modulemadness = 0;
            while (temp > 0) {
                temp = Math.floorDiv(temp, 3);
                temp = temp - 2;
                if (temp < 0) break;
                modulemadness += temp;
            }
            resultList.add(modulemadness);
            resultSum += modulemadness;
        }
        System.out.println(resultSum);
    }
}

