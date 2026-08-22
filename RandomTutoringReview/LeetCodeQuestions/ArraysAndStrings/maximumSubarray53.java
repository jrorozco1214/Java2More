package LeetCodeQuestions.ArraysAndStrings;

public class maximumSubarray53 {

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-1}));
    }

    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;

        for(int i = 0; i < nums.length; i++){

            runningSum += nums[i];

            maxSum = Math.max(maxSum, runningSum);
        
            if(runningSum < 0){
                
                runningSum = 0;
            }
        }

        return maxSum;
    }
    
}
