package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class maxSumOfAPairwithEqualSumOfDigits2342 {

    public static void main(String[] args) {
        
        maximumSum(new int[]{4,6,10,6});
    }

    public static int maximumSum(int[] nums){

        HashMap<Integer, ArrayList<Integer>> pairs = new HashMap<>();
        int keySum = 0;

        int totalMax = -1;

        for(Integer num: nums){

            int temp = num;

            while(num > 0){

                keySum += num % 10;

                num /= 10;
            }

            if(!pairs.containsKey(keySum)){

                ArrayList<Integer> pair = new ArrayList<>();
                pairs.put(keySum, pair);
                pairs.get(keySum).add(temp);

            } else {

                pairs.get(keySum).add(temp);
            }
            keySum = 0;

        }

        for(Integer x: pairs.keySet()){

            ArrayList<Integer> currList = pairs.get(x);

            if(currList.size() > 1){

                Collections.sort(currList, Collections.reverseOrder());
                totalMax = Math.max(totalMax, currList.get(0)+currList.get(1));
            }
        }

        return totalMax;
    }
}
