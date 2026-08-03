package LeetCodeQuestions.BinarySearch;

public class splitArrayLargestSum410 {

    public static void main(String[] args) {


        System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
    }

    public static int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        for(Integer x: nums){

            left = Math.max(left, x);
            right += x;
        }


        while(left <= right){

            int mid = left + (right - left) / 2;

            if(check(nums, k, mid)) {

                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean check(int[] nums, int k, int mid){

        int count = 1;
        int sum = 0;

        for(Integer num: nums){

            sum += num;
            
            if(sum > mid) {

                sum = num;
                count++;
            }
        }

        return count <= k;
    }
    
}
