package LeetCodeQuestions.ArraysAndStrings;

public class subArrayProductLessThanK713 {

    public static void main(String[] args) {
        
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int left = 0;
        int curr = 1;
        int ans = 0;

        for(int right = 0; right < nums.length; right++){

            curr *= nums[right];

            while(curr >= k){

                curr /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }
        return ans;
    }
}
