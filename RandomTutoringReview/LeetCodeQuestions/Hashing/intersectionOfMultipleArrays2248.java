package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class intersectionOfMultipleArrays2248 {

    public static void main(String[] args) {

        System.out.println(intersection(new int[][]{
            {3,1,2,4,5},{1,2,3,4},{3,4,5,6}
        }));
    }

    public static List<Integer> intersection(int[][] nums) {

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            for(int j = 0; j < nums[i].length; j++){

                counts.put(nums[i][j], counts.getOrDefault(nums[i][j], 0) + 1);
            }
        }

        for(Integer x: counts.keySet()){

            if(counts.get(x) == nums.length){

                result.add(x);
            }
        }
        Collections.sort(result);

        return result;
    }
}
