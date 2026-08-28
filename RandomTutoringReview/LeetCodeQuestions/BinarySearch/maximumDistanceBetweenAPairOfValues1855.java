package LeetCodeQuestions.BinarySearch;

import java.util.Arrays;

public class maximumDistanceBetweenAPairOfValues1855 {

    public static void main(String[] args) {

        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
    }

    public static int x = 10;

    public static int maxDistance(int[] nums1, int[] nums2) {

        int left = 0;
        int right = nums2.length;

        int maxDistance = 0;

        for(int i = 0; i < nums1.length; i++){

            while(left < right) {

                int mid = left + (right - left) / 2;
                

                if(nums2[mid] < nums1[i]) {

                    right = mid;
                } else {

                    left = mid + 1;
                }
            }

            left = left - 1;

            if(left > i) {

                maxDistance = Math.max(maxDistance, left - i);
            }
            
            left = 0;
            right = nums2.length;
        }

        return maxDistance;
    }
    
}
