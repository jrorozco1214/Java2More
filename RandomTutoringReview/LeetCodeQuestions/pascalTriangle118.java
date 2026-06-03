package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle118 {

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> prevRow = new ArrayList<>();

        for(int i = 0; i < numRows; i++){

            ArrayList<Integer> currentRow = new ArrayList<>();

            for(int j = 0; j < i + 1; j++){

                if(j == 0 || j == i){

                    currentRow.add(1);
                } else {

                    currentRow.add(prevRow.get(j-1) + prevRow.get(j));
                } 
            }
            result.add(new ArrayList<>(currentRow));
            prevRow = currentRow;
        }

        return result;
    }
}
