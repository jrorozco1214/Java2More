package LeetCodeQuestions.BinarySearch;

import java.util.HashSet;

public class findPeakElement162 {

    public static void main(String[] args) {

        System.out.println(findPeakElement(new int[]{1,2}));
    }

    public static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if((mid == nums.length-1 || nums[mid+1] < nums[mid]) && (mid == 0 || nums[mid-1] < nums[mid])){

                return mid;
            }

            if(nums[mid+1] > nums[mid]) {

                left = mid+1;
            } else {

                right = mid-1;
            }
        }

        return -1;
    }
}
