package LeetCodeQuestions;

import java.util.ArrayList;

public class containerWithMostWater11 {

    public static void main(String[] args) {

        int[] heights = {2,5,1,11,13,12,1,3};

        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length-1;

        int max = 0;


        while(left < right) {

            int area = (right - left) * Math.min(heights[left], heights[right]);

            max = Math.max(area, max);

            if(heights[left] > heights[right]){

                right--;
            } else {

                left++;
            }
        }

        return max;
    }
    
}
