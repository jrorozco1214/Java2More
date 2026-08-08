package LeetCodeQuestions.ArraysAndStrings;

import java.util.HashMap;

public class subArraysSumEqualsK560 {

    public static void main(String[] args) {
        
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        int currentSum = 0;
        int ans = 0;

        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);

        for(Integer num: nums) {

            currentSum += num;

            if(sumCount.containsKey(currentSum-k)) {

                ans += sumCount.get(currentSum-k);
            }

            sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0)+1);
        }

        return ans;
    }
    
}
