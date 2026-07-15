package LeetCodeQuestions.ArraysAndStrings;

public class runningSumOf1dArray1480 {

    public static void main(String[] args) {
        
        int[] result = runningSum(new int[]{1,2,3,4});

        for(Integer x: result){

            System.out.println(x);
        }
    }

    public static int[] runningSum(int[] nums) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++){

            prefix[i] = prefix[i-1] + nums[i];
        }

        return prefix;
    }
}
