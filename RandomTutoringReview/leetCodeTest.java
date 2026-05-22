import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import TestPractice.book;

public class leetCodeTest {
    
    public static void main(String[] args) {

        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = {1,2,2};
        int m = 6;
        int n = 3;

        System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int index = 0;

        if(m == 0 && n == 0){
            System.out.println(nums1);
        } else if (m > 0 && n == 0){
            System.out.println(nums1);
        } else if(m == 0 && n > 0){

            for(int i = 0; i < nums2.length; i++){
                nums1[i] = nums2[i];
            }
        } else {

            for(int j = 0; j < nums1.length; j++){

                if(nums1[j] == 0 && index < nums2.length){

                    nums1[j] = nums2[index];
                    index++;
                }
            }
        }
        Arrays.sort(nums1);

        return nums1;
    }
}
