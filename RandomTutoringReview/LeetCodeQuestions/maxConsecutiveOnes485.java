package LeetCodeQuestions;

public class maxConsecutiveOnes485 {

    public static void main(String[] args) {
        
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0}));
    }

        public static int findMaxConsecutiveOnes(int[] nums) {

            if(nums.length <= 1){

                return nums[0];
            }

            int minWindow = Integer.MIN_VALUE;
            int windowStart = 0;

            for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){

                if(nums[windowEnd] == 1){ //if this equals 0 can i do better and
                    windowStart = windowEnd+1;

                    while(windowStart < nums.length){ //can we do better

                        if(nums[windowStart] == 1){

                            minWindow = Math.max(minWindow, (windowStart + 1) - windowEnd);
                            windowStart++;
                        } else {
                            break;
                        }
                    }
                }
            }

            if(minWindow == Integer.MIN_VALUE){
                minWindow = 0;
            }
            return minWindow;
    } 
}
