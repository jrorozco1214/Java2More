package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class concatenationOfArray1929 {

    public static void main(String[] args) {

        int[] ar = {1,2,1};

        System.out.println(Arrays.toString(getConcatenation(ar)));

    }

    public static int[] getConcatenation(int[] nums) {

        int index = 0;

        int[] result = new int[2*nums.length];

        for(int i = 0; i < nums.length; i++){

            result[i] = nums[i];
            index++;
        }


        for(int i = 0; i < nums.length; i++){
            result[index] = nums[i];
            index++;
        }

        return result;
    }
}
