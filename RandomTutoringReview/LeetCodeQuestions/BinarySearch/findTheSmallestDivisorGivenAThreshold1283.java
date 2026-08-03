package LeetCodeQuestions.BinarySearch;

public class findTheSmallestDivisorGivenAThreshold1283 {

    public static void main(String[] args) {

        System.out.println(smallestDivisor(new int[]{1,2,5,9}, 6));
    }

    public static int smallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = 44;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(check(nums, mid, threshold)) {

                right = mid - 1;
            } else {

                left = mid + 1;
            }
            
        }
        return left;
    }

    public static boolean check(int[] nums, double mid, int threshold){

        double result = 0;

        for(Integer x: nums){

            result+= Math.ceil(x / mid);
        }

        return (int)result <= threshold;
    }
    
}
