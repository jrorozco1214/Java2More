package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class threeSum15 {


    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{0,0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int k = nums.length-1;

            while(j < k) {

                if(nums[i] + nums[j] + nums[k] == 0) {

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    
                    break;
                } else if(nums[i] + nums[j] + nums[k] < 0) {

                    j++;
                } else {

                    k--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
