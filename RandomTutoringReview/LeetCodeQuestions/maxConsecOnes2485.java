package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class maxConsecOnes2485 {

    public static void main(String[] args) {


        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        if(nums.length <= 1){
            return nums[0];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int counter = 1;
        for(int i = 0; i < nums.length; i++){

            for(int j = i+1; j < nums.length; j++){

                if(nums[i] == 1 && nums[j] == 1) {
                    counter++;
                    continue;
                } else if(nums[j] == 0 && nums[i] == 1){
                    
                    result.add(counter);
                    counter = 1;
                    break;
                }
            }
        }

        if(result.isEmpty()){
            return 0;
        }
        return Collections.max(result);
    }
}
