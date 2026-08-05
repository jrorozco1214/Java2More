package LeetCodeQuestions.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class maximumSizeSubarraySumEqualsK325 {

    public static void main(String[] args) {

        System.out.println(maxSubArrayLen(new int[]{-2,-1,2,1}, 1));
    }

    public static int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int runningSum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){

            runningSum += nums[i];

            if(sumIndex.containsKey(runningSum - k)) {

                ans = Math.max(ans, i - sumIndex.get(runningSum-k));
            }

            if(!sumIndex.containsKey(runningSum)) {

                sumIndex.put(runningSum, i);
            }
        }

        return ans;
    }
}
