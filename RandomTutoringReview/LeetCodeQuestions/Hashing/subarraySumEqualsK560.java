package LeetCodeQuestions.Hashing;

import java.util.HashMap;

public class subarraySumEqualsK560 {

    public static void main(String[] args) {

        subarraySum(new int[]{2,3,-5,5,-5,1,4}, 5);
    }
    
    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> sumAndCount = new HashMap<>();

        sumAndCount.put(0, 1);

        int currentSum = 0;
        int result = 0;

        for(int i = 0; i < nums.length; i++){

            currentSum += nums[i];

            sumAndCount.put(currentSum, sumAndCount.getOrDefault(currentSum, 0) + 1);

            int sub = currentSum - k;

            if(currentSum == k && sumAndCount.containsKey(sub)){

                result += sumAndCount.get(currentSum);
            }

        }

        return result;
    }
}
