package LeetCodeQuestions.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum1 {

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(twoSum(new int[]{5,2,7,10,3,9}, 8)));
    }


    public static int[] twoSum(int[]nums, int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            
            map.put(nums[i], i);
            int calc = target - nums[i]; 

            if(map.containsValue(calc)){
                
                return new int[]{i, map.get(calc)};
            }
        }

        return new int[]{-1,-1};
    }
}
