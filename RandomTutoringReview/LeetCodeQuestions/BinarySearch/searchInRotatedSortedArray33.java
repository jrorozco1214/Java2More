package LeetCodeQuestions.BinarySearch;

import java.util.Arrays;

public class searchInRotatedSortedArray33 {

    public static void main(String[] args) {


        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    
    public static int search(int[] nums, int target) {

        int[] afterLowestValue = null;
        int[] beforeLowestValue = null;

        int left = 0;
        int leadingRight = 1;

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] > nums[leadingRight]) {

                beforeLowestValue = new int[leadingRight];
                afterLowestValue = new int[nums.length - leadingRight];
                

                while(left < leadingRight) {

                    beforeLowestValue[left] = nums[left];
                    left++;
                }
                int i = 0;

                while(leadingRight < nums.length) {

                    afterLowestValue[i] = nums[leadingRight];
                    i++;
                    leadingRight++;
                }
                break;
            }
            leadingRight++;
        }


        if(afterLowestValue[afterLowestValue.length-1] <= target) {

            int leftBinary = 0;
            int rightBinary = afterLowestValue.length;

            while(leftBinary <= rightBinary) {

                int mid = leftBinary + (leftBinary - rightBinary) / 2;

                if(afterLowestValue[mid] == target) {

                    return mid;
                }

                if(afterLowestValue[mid] > target) {

                    rightBinary = mid - 1;
                } else {

                    leftBinary = mid + 1;
                }
            }

        } else {

            int leftBinary = 0;
            int rightBinary = 0;

            while(leftBinary <= rightBinary) {

                int mid = leftBinary + (leftBinary - rightBinary) / 2;

                if(afterLowestValue[mid] == target) {

                    return mid;
                }

                if(afterLowestValue[mid] > target) {

                    rightBinary = mid - 1;
                } else {

                    leftBinary = mid + 1;
                }
            }
        }

        return -1;
    }
}
