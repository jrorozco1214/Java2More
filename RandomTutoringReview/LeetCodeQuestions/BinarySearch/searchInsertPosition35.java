package LeetCodeQuestions.BinarySearch;

public class searchInsertPosition35 {

    public static void main(String[] args) {
        
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){

                right = mid;
            } else {

                left = mid + 1;
            }
        }
        
        return left;
    }
}
