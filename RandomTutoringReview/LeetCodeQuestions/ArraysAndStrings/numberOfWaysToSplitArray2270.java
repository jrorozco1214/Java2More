package LeetCodeQuestions.ArraysAndStrings;

public class numberOfWaysToSplitArray2270 {

    public static void main(String[] args) {

        waysToSplitArray(new int[]{10,4,-8,7});
    }

    public static int waysToSplitArray(int[] nums) {

        int leftSect = 0;
        int total = 0;
        int ans = 0;

        for(Integer x: nums){

            total += x;
        }

        for(int i = 0; i < nums.length; i++){
            leftSect = nums[i];
            int rightSect = total - leftSect;

            if(leftSect >= rightSect){

                ans++;
            }

        }

        return ans;
    }
    
}
