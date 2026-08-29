package LeetCodeQuestions.BinarySearch;

public class capacityToShipPackagesWithinDDays1011 {

    public static void main(String[] args) {
        
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = Integer.MAX_VALUE;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(check(weights, days, mid)){

                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean check(int[] weights, int days, int mid){

        int counter = 1;
        int runningSum = 0;

        for(Integer x: weights){

            runningSum += x;

            if(runningSum > mid){

                counter++;
                runningSum = x;;
            }
        }

        return counter <= days;
    }
}
