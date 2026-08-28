package LeetCodeQuestions.PrefixSum;

public class findPivotIndex724 {

    public static void main(String[] args) {

        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{1,2,3}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }

    public static int pivotIndex(int[] nums){

        for(int i = 0; i < nums.length; i++){

            int leftIndex = 0;
            int rightIndex = nums.length-1;

            int leftSum = 0;
            int rightSum = 0;

            while(leftIndex < i){

                leftSum += nums[leftIndex];
                leftIndex++;
            }

            while(rightIndex > i) {

                rightSum += nums[rightIndex];
                rightIndex--;
            }

            if(leftSum == rightSum){

                return i;
            }
        }

        return -1;
    }

    public static int pivotIndexTwo(int[] nums){

        int sum = 0;
        int leftsum = 0;
      
        for (int x: nums){
          
          sum += x;
        }
        
        for (int i = 0; i < nums.length; ++i) {
          
            if (leftsum == sum - leftsum - nums[i]) {
              
                return i;
            }

            leftsum += nums[i];
        }
        return -1;
    }
}
