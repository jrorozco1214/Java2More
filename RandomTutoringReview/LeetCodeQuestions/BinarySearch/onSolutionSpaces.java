package LeetCodeQuestions.BinarySearch;

public class onSolutionSpaces {

    public static void main(String[] args) {

        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    public static int limit;
    
    public static int minEatingSpeed(int[] piles, int h) {
        limit = h;
        int left = 1;
        int right = 0;
        
        for (int bananas: piles) {
            right = Math.max(right, bananas);
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, piles)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public static boolean check(double k, int[] piles) {
        int hours = 0;
        for (double bananas: piles) {
            hours += Math.ceil(bananas / k);
        }
        
        return hours <= limit;
    }
    
}
