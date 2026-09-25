package LeetCodeQuestions.CapitalOne;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix54 {

    public static void main(String[] args) {
        
        System.out.println(spiralOrder(new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        }));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        int left = 0;

        int bottom = matrix.length-1;
        int right = matrix[0].length-1;

        while(true){


            for(int columnX = left; columnX <= right; columnX++){

                result.add(matrix[top][columnX]);
            }

            if(calcArea(top, left, bottom, right) <= 0) break;

            top++;

            for(int rowY = top; rowY <= bottom; rowY++){

                result.add(matrix[rowY][right]);
            }

            
            if(calcArea(top, left, bottom, right) <= 0) break;
            right--;

            for(int columnX = right; columnX >= left; columnX--){

                result.add(matrix[bottom][columnX]);
            }

            
            
            if(calcArea(top, left, bottom, right) <= 0) break;
            bottom--;

            for(int rowY = bottom; rowY >= top; rowY--){

                result.add(matrix[rowY][left]);
            }

            if(calcArea(top, left, bottom, right) <= 0) break;

            left++;
        }


        return result;
    }

    public static int calcArea(int top, int left, int bottom, int right){

        return (right-left+1) * (bottom - top + 1);
    }
}
