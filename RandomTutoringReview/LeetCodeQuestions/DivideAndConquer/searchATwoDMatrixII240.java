package LeetCodeQuestions.DivideAndConquer;

public class searchATwoDMatrixII240 {

    public static void main(String[] args) {

        System.out.println(searchMatrix(new int[][]{
            {1,4,7,11}, 
            {2,5,8,12}, 
            {3,6,9,16}, 
            {10,13,14,17}, 
            {18,21,23,26}
        }, 4));

        // System.out.println(searchMatrix(new int[][]{
        //     {1,4,7,11}, 
        //     {2,5,8,12}, 
        //     {3,6,9,16}, 
        //     {10,13,14,17}, 
        //     {18,21,23,26}
        // }, 11));

        // System.out.println(searchMatrix(new int[][]{
        //     {1,4,7,11}, 
        //     {2,5,8,12}, 
        //     {3,6,9,16}, 
        //     {10,13,14,17}, 
        //     {18,21,23,26}
        // }, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        return searchSubMatrix(matrix, target, 0, matrix[0].length, 0, matrix.length);
    }

    public static boolean searchSubMatrix(int[][] matrix, int target, int left, int right, int top, int bottom){

        int width = right-left;
        int height = bottom - top;

        if(width == 0 || height == 0){

            return false;
        }

        
        int xIndex = left + (width/2);
        int yIndex = top + (height/2);

        int mid = matrix[yIndex][xIndex];

        System.out.printf("x = %d - %d    y = %d - %d Mid: %d %n", left, right, top, bottom, mid);
        System.out.flush();

        if(mid == target){

            return true;
        }


        if(mid > target){

            if(searchSubMatrix(matrix, target, left, xIndex, yIndex, bottom)) {

                return true;
            }

            return searchSubMatrix(matrix, target, left, right, top, yIndex);
        } else {

            if(searchSubMatrix(matrix, target, xIndex+1, right, top, yIndex+1)) {

                return true;
            }

            return searchSubMatrix(matrix, target, left, right, yIndex+1, bottom);
        }
    }
}
