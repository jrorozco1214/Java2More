package LeetCodeQuestions.Hashing;

import java.util.HashSet;

public class maximumErasureValue1695 {

    public static void main(String[] args) {


        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {

        int currSum = 0;
        int start = 0;

        int max = 0;

        HashSet<Integer> tracker = new HashSet<>();

        for(int end = start; end < nums.length; end++){
            
            while(tracker.contains(nums[end])) {

                currSum -= nums[start];
                tracker.remove(nums[start]);
                start++;
            }

            tracker.add(nums[end]);
            currSum += nums[end];
            
            max = Math.max(currSum, max);
        }

        return max;
    }
    
}
