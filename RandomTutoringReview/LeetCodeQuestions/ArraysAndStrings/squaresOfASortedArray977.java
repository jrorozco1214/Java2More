package LeetCodeQuestions.ArraysAndStrings;

import java.util.Arrays;

public class squaresOfASortedArray977 {

    public static void main(String[] args) {


        int[]x = sortedSquares(new int[]{-4,-1,0,3,10});

        for(Integer a: x){

            System.out.println(a);
        }
    }
    
    public static int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int i = 0;
        int j = 0;

        while(i < nums.length && j < nums.length){

            result[i] = nums[j] * nums[j];
            i++;
            j++;
        }

        Arrays.sort(result);

        return result;
    }
}
