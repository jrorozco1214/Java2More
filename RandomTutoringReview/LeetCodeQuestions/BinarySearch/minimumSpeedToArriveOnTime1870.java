package LeetCodeQuestions.BinarySearch;

public class minimumSpeedToArriveOnTime1870 {

    public static void main(String[] args) {

        System.out.println(minSpeedOnTime(new int[]{1,3,2}, 1.9));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {

        if(dist.length > Math.ceil(hour)){

            return -1; 
        }

        double left = 1;
        double right = Math.pow(10, 7);

        while(left <= right){

            double mid = left + (right - left) / 2;

            if(check(mid, dist, hour)){

                right = mid - 1;
            } else {

                left = (mid + 1);
            }
        }

        return (int)left; //this is the minimum if you want to return the max it would be the right
    }

    public static boolean check(double mid, int[] distance, double hourConstraint){

        double result = 0;

        for(double d: distance){

            result = Math.ceil(result);

            result += d / mid;
        }

        return result <= hourConstraint;
    }
}
