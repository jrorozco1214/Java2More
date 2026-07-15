package LeetCodeQuestions.ArraysAndStrings;

public class minimumValueToGetPositiveStepByStepSum1413 {

    public static void main(String[] args) {

        System.out.println(minStartValue(new int[]{1,2}));
    }

    public static int minStartValue(int[] nums){

        int answer = 0;
        int total = 0;

        for(int i = 0; i < nums.length; i++){

            total += nums[i];
            answer = Math.min(total, answer);
        }

        //System.out.println(answer);

        return -answer + 1;

    }
    
}
