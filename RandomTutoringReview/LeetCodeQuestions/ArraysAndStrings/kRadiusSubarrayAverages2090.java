package LeetCodeQuestions.ArraysAndStrings;

import java.util.Arrays;

public class kRadiusSubarrayAverages2090 {

    public static void main(String[] args) {
        
        int[] a = {7,4,3,9,1,8,5,2,6};

        System.out.println(Arrays.toString(getAverages(a, 3)));
    }

    public static int[] getAverages(int[] nums, int k) {

        int sum = 0;
        int[] prefixSum = new int[nums.length];
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            prefixSum[i] = sum;
        }

        for(int i = 0; i < nums.length; i++){
            

            if(i < k || i >= nums.length - k){

                result[i] = -1;
            } else {

                int sumBefore = 0;

                if(i-k-1 >= 0){

                    sumBefore = prefixSum[i-k-1];
                }
                int rangeSum = prefixSum[i + k];
                rangeSum -= sumBefore;

                result[i] = rangeSum / (k * 2 + 1);
            }
        }

        return result;
    }
}
