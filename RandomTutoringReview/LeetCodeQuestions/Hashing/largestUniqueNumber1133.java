package LeetCodeQuestions.Hashing;

import java.util.HashMap;

public class largestUniqueNumber1133 {

    public static void main(String[] args) {

        System.out.println(largestUniqueNumber(new int[]{9,9,8,8}));
    }

    public static int largestUniqueNumber(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(Integer x: nums){

            count.put(x, count.getOrDefault(x, 0)+1);
        }

        int maxNum = -1;
        
        for(Integer x: count.keySet()){

            if(count.get(x) < 2){

                maxNum = Math.max(maxNum, x);
            }
        }

        return maxNum;
    }
}
