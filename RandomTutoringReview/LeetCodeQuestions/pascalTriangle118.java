package LeetCodeQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class pascalTriangle118 {

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        int one = 1;

        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j = 0; j < i + 1; j++){
                temp.add(one);
            }
            result.add(new ArrayList<>(temp));
        }

        int num = 0;
        int windowSize = 2;
        int resultSize = result.size();

        int counter = 0;

        for(int i = 0; i < result.size(); i++){


            for(int j = i+1; j < result.get(i).size(); j++){

                int num1 = result.get(i-1).get(j-1) + result.get(i).get(j);

                result.get(i).add(num1,j);

            }
        }

        return result;
    }
}
