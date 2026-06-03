package LeetCodeQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import TestPractice.Recursion.ar;

public class removingDuplicatesFromSortedArray26 {

    public static void main(String[] args) {


        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {

        int p1 = 0;
        int p2 = 1;


        while(p2 != nums.length){

            if(nums[p1] != nums[p2]){

                p1++;
                nums[p1] = nums[p2];
            }

            p2++;

        }

        System.out.println(Arrays.toString(nums));

        return p1+1;
    }
    
}
