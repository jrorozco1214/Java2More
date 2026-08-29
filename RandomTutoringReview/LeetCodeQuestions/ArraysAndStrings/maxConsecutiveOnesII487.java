package LeetCodeQuestions.ArraysAndStrings;

public class maxConsecutiveOnesII487 {

    public static void main(String[] args) {


        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1}));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        if(nums.length <= 1){

            return 1;
        }

        int left = 0;
        boolean seenZero = false;

        int ans = 0;

        for(int right = 0; right < nums.length; right++){

            if(nums[right] == 0){

                if(seenZero) {

                    ans = Math.max(ans, (right-1)-left+1);

                    while(nums[left] != 0){

                        left++;
                    }
                    left++;
                } else {

                    seenZero = true;
                }
            }
        }

        if(ans == 0){

            return (nums.length-1) - left + 1;
        } else {

            ans = Math.max(ans, (nums.length-1) - left + 1);
        }

        return ans;
    }
}
