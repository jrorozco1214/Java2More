package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class intersectionOfTwoArrays349 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersection(new int[]{4,9, 5}, new int[]{9,4,9,8,4})));
    }


    public static int[] intersection(int[] nums1, int[] nums2){

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        ArrayList<Integer> result = new ArrayList<>();


        while(p1 < nums1.length && p2 < nums2.length){

            if(nums1[p1] == nums2[p2]){

                int val1 = nums1[p1];

                result.add(val1);

                while(nums1[p1] == val1){

                    p1++;

                    if(p1 >= nums1.length){
                        break;
                    }
                }

                p2++;
            } else if (nums1[p1] < nums2[p2]) {

                p1++;
            } else {
                p2++;
            }
        }

        int[] arr = new int[result.size()];

        for(int i = 0; i < result.size(); i++){

            arr[i] = result.get(i);
        }

        return arr;

    }
    
}
