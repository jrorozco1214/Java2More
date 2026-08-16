package LeetCodeQuestions.BinarySearch;

public class findMinimumInRotatedSortedArray153 {

    public static void main(String[] args) {

        System.out.println(findMin(new int[]{8,0,1,2,3,4,5,6,7}));
    }

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left < right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {

                left = mid + 1;
            } else {

                right = mid;
            }
        }

        int target = 3;

        int l = 0;
        int pivot = left;
        int r = nums.length-1;

        if(nums[pivot] <= target && nums[r] >= pivot){

            while(pivot < r) {

                int mid = pivot + (r - pivot) / 2;

                if(nums[mid] <= target) {
                    
                    r = mid + 1;
                } else {

                    l = mid;
                }
            }
        } else {

            while(l < pivot) {

                int mid = pivot + (r - pivot) / 2;

                if(nums[mid] <= target) {
                    
                    r = mid + 1;
                } else {

                    l = mid;
                }
            }
        }


        return left;
    }
}
