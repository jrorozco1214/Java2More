package LeetCodeQuestions.Hashing;

import java.util.HashSet;

public class missingNumber268 {

    public static void main(String[] args) {

        System.out.println(missingNumber(new int[]{0,1}));
    }
    
    public static int missingNumber(int[] nums){

        HashSet<Integer> set = new HashSet<>();

        for(Integer x: nums){

            set.add(x);
        }

        int result = nums.length;
        
        for(int i= 0; i < nums.length; i++){

            if(!set.contains(result)){

                return result;
            }

            result-=1;
        }

        return 0;
    }
}
