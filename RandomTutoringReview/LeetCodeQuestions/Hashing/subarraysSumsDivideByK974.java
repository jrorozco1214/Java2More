package LeetCodeQuestions.Hashing;

import java.util.HashMap;

public class subarraysSumsDivideByK974 {

    public static void main(String[] args) {
        
        System.out.println(subarraysDivByK(new int[]{5}, 9));
    }

    public static int subarraysDivByK(int[] nums, int k){

        int currSum = 0;
        int ans = 0;

        int[]prevSumCounts = new int[k];
        prevSumCounts[0] = 1;

        for(Integer currNum: nums){

            if(currNum < 0){

                currSum += (currNum % k) + k;
            } else {

                currSum += currNum % k;
            }

            currSum %= k; //done again to stay in range of 0 to k

            ans += prevSumCounts[currSum]; //adding to our answer from the index of the array

            prevSumCounts[currSum]++;
        }

        return ans;
    }
}
