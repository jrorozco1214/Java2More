package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class equalRowAndColumnPairs2352 {

    public static void main(String[] args) {
        
        System.out.println(equalPairs(new int[][]{
            {3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}
        }));
    }

    public static int equalPairs(int[][] grid) {

        HashMap<String, Integer> rows = new HashMap<>();
        HashMap<String, Integer> columns = new HashMap<>();

        int totalEqual = 0;

        for(int[] row: grid) {

            String numKey = Arrays.toString(row);

            rows.put(numKey, rows.getOrDefault(numKey, 0)+1);
        }

        for(int j = 0; j < grid[0].length; j++){

            int[] colArray = new int[grid.length];

            for(int i = 0; i < grid.length; i++){

                colArray[i] = grid[i][j];
            }


            String stringCol = Arrays.toString(colArray);

            columns.put(stringCol, columns.getOrDefault(stringCol, 0)+1);
        }

        for(String key: rows.keySet()){

            totalEqual += rows.get(key) * columns.getOrDefault(key, 0);
        }

        return totalEqual;
    }
}
