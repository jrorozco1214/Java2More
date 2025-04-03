package TestPractice.Recursion;

public class groupSum {

    public static void main(String[] args) {
        
    }

    public static boolean groupSum(int start, int[]nums, int target){


        if(start == nums.length){
            if(n == target){
                return true;
            } else {
                return false;
            }
        } else {
            int n = 0;
            n+=nums[start];
            
            return groupSum(start+1, nums, target);
        }
    }
    
}
