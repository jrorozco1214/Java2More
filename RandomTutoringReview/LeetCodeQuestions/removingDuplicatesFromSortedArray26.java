package LeetCodeQuestions;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class removingDuplicatesFromSortedArray26 {

    public static void main(String[] args) {


        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        
        Set<Integer> result = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            result.add(nums[i]);
        }

        System.out.println(result);

        return result.size();
    }
    
}
