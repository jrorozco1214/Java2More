package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class contiguousArray525 {

    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }

    public static int findMaxLength(int[] nums) {

        int[] editedNums = new int[nums.length];
        HashMap<Integer, Integer> sumTracker = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 0){

                editedNums[i] = -1;
            } else {

                editedNums[i] = nums[i];
            }
        }

        int ans = 0;
        int curr = 0;

        sumTracker.put(0, -1);

        for(int i = 0; i < editedNums.length; i++){

            curr += editedNums[i];

            if(sumTracker.containsKey(curr)){

                ans = Math.max(ans, i-sumTracker.get(curr));
            } else{

                sumTracker.put(curr, i);
            }
        }

        return ans;
    }

    public static int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {

            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {

                maxlen = Math.max(maxlen, i - map.get(count));
            } else {

                map.put(count, i);
            }
        }
        System.out.println(map);
        return maxlen;
    }
}
