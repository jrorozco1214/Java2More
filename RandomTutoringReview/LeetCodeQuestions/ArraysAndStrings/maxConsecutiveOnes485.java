package LeetCodeQuestions.ArraysAndStrings;

public class maxConsecutiveOnes485 {

    public static void main(String[] args) {


        System.out.println(findMaxConsecutiveOnes(new int[]{0,0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums){

        int left = 0;
        int ans = 0;
        int k = 0;
        int size = 0;

        for(int right = 0; right < nums.length; right++){

            if(nums[right] == 0){

                k++;

                while(k > 0){

                    if(nums[left] == 0){
                        k = 0;
                    }
                    left++;
                }
            } else {

                size = right - left + 1;
                ans = Math.max(ans, size);
            }
        }

        return ans;
    }
    
}
