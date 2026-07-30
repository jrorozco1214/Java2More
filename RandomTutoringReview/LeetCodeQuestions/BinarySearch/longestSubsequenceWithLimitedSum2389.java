package LeetCodeQuestions.BinarySearch;

import java.util.Arrays;
import java.util.ArrayList;

public class longestSubsequenceWithLimitedSum2389 {
    

    public static void main(String[] args) {

        System.out.println(Arrays.toString(answerQueries(new int[]{2,3,4,5}, new int[]{1})));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);

        int[] prefixSum = new int[nums.length];

        int runningSum = 0;

        for(int i = 0; i < nums.length; i++){

            runningSum += nums[i];
            prefixSum[i] = runningSum;
        }

        int[] answerArray = new int[queries.length];

        for(int i = 0; i < queries.length; i++){

            int index = binarySearch(prefixSum, queries[i]);

            answerArray[i] = index;
        }

        return answerArray;
    }

    public static int binarySearch(int[] prefixSum, int target){

        int left = 0;
        int right = prefixSum.length;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(prefixSum[mid] > target){

                right = mid;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }
}
