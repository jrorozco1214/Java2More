package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class contiguousArray525 {

    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }

    public static int findMaxLength(int[] nums) {

        int[] editedNums = new int[nums.length];
        HashMap<Integer, ArrayList<Integer>> sumTracker = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 0){

                editedNums[i] = -1;
            } else {

                editedNums[i] = nums[i];
            }
        }

        int sum = 0;

        int tempAns = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){

            sum += editedNums[i];
            sumTracker.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);

        }

        System.out.println(sumTracker);


        return 0;
    }
}
