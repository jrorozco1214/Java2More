package LeetCodeQuestions.BinarySearch;

public class searchA2DMatrix74 {

    public static void main(String[] args) {


        System.out.println(searchMatrix(new int[][]{
            {0,1,2,3},
            {4,5,6,7},
            {8,9,10,11}
            }, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target){

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int num = matrix[row][col];
            
            if (num == target) {
                return true;
            }
            
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
