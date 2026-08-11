package LeetCodeQuestions.BinarySearch;

public class searchInRoatedSortedArrayNum233 {

    public static void main(String[] args) {


        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int leadingRight = 1;

        if(nums.length == 1) {

            return target == nums[0] ? 0 : -1;
        }

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] > nums[leadingRight]) {

                if(target <= nums[right] && target >= nums[left]) {

                    while(left <= right) {

                        int mid = left + (right - left) / 2;

                        if(nums[mid] == target) {

                            return mid;
                        }

                        if(nums[mid] > target){

                            right = mid - 1;
                        } else {

                            left = mid + 1;
                        }
                    }

                    return -1;
                } else {
                    left = leadingRight;
                    right = nums.length-1;

                    while(left <= right) {

                        int mid = left + (right - left) / 2;

                        if(nums[mid] == target) {

                            return mid;
                        }

                        if(nums[mid] > target){

                            right = mid - 1;
                        } else {

                            left = mid + 1;
                        }
                    }
                    return -1; 
                }
            }

            leadingRight++;
        }

        return -1;
    }
}
