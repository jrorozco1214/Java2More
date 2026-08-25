package LeetCodeQuestions.ArraysAndStrings;

import java.util.Arrays;

public class threeSumClosest16 {

    public static void main(String[] args) {


        System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {

        int minRange = Integer.MAX_VALUE;
        int closestSum = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            int left = i + 1;
            int right = nums.length-1;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];
                int calcRange = Math.abs(sum - target);

                if(calcRange < minRange) {

                    minRange = calcRange;
                }

                if(sum < target){

                    left++;
                } else {

                    right--;
                }
            }
        }

        return target-minRange;
    }
}
