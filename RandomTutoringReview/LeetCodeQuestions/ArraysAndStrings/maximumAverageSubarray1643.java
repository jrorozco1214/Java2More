package LeetCodeQuestions.ArraysAndStrings;

public class maximumAverageSubarray1643 {

    public static void main(String[] args) {


        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {

        double curr = 0;

        for(int i = 0; i < k; i++){

            curr += nums[i];
        }

        double answer = curr;

        for(int i = k; i < nums.length; i++){

            curr += nums[i] - nums[i-k];
            answer = Math.max(answer, curr);
        }
        return answer / k;
    }
}
