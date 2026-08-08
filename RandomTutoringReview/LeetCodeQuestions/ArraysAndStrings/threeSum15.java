package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class threeSum15 {


    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Iny>> finalResult = new ArrayList<>();

        HashSet<ArrayList<Integer>> result = new HashSet<>();

        ArrayList<Integer> temp;

        for(int i = 0; i < nums.length; i++) {

            if(i == nums.length - 2) {
sss
                break;
            }

            int j = i+1;

            while(j < nums.length) {

                int k = j + 1;
                while(k < nums.length) {

                    if(nums[i] + nums[j] + nums[k] == 0){

                        temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        result.add(temp);
                    }
                    k++;
                }
                j++;
            }
        }

        System.out.println(result);

        return finalResult;
    }
}
