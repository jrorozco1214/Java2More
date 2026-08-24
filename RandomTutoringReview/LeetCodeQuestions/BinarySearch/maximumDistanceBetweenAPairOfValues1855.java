package LeetCodeQuestions.BinarySearch;

import java.util.Arrays;

public class maximumDistanceBetweenAPairOfValues1855 {

    public static void main(String[] args) {

        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {

        int left = 0;
        int right = nums2.length-1;

        int maxDistance = 0;

        for(int i = 0; i < nums1.length; i++){

            while(left < right) {

                int mid = left + (right - left+1) / 2;
                

                if(nums1[i] <= nums2[mid]) {

                    left = mid;
                } else {

                    right = mid - 1;
                }

                // if(nums2[mid] < nums1[i]){
                  
                //     right = mid - 1;
                // } else {
                  
                //   left = mid;
                // }
            }

            if(left > i) {

                maxDistance = Math.max(maxDistance, left - i);
            }
            
            left = 0;
            right = nums2.length-1;
        }

        return maxDistance;
    }
    
}
