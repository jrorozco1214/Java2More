package LeetCodeQuestions.DynamicProgramming;

public class uniquePaths62 {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {


        int[][] grid = new int[m][n];

        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                if(i == 0 || j == 0){

                    grid[i][j] = 1;
                } else {

                    grid[i][j] = grid[i-1][j] + grid[i][j-1];

                }
            }
        }

        return grid[m-1][n-1];
    }
    
}
