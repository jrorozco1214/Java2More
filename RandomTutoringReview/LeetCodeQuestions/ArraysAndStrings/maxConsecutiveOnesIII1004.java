package LeetCodeQuestions.ArraysAndStrings;

public class maxConsecutiveOnesIII1004 {

    public static void main(String[] args) {

        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int ans = 0;
        int currKCount = 0;
        int size = 0;

        for(int right = 0; right < nums.length; right++){

            if(nums[right] == 0){

                currKCount++;
            }

            while(currKCount > k){

                if(nums[left] == 0){

                    currKCount--;
                }
                left++;
            }

            size = right - left + 1;
            ans = Math.max(ans, size);
        }

        return ans;
    }
}
