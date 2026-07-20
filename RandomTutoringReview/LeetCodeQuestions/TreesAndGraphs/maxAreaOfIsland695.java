package LeetCodeQuestions.TreesAndGraphs;

public class maxAreaOfIsland695 {

    public static void main(String[] args) {
        
        // int [][]grid = {
        //     {0,0,1,0,0,0,0,1,0,0,0,0,0},
        //     {0,0,0,0,0,0,0,1,1,1,0,0,0},
        //     {0,1,1,0,1,0,0,0,0,0,0,0,0},
        //     {0,1,0,0,1,1,0,0,1,0,1,0,0},
        //     {0,1,0,0,1,1,0,0,1,1,1,0,0},
        //     {0,0,0,0,0,0,0,0,0,0,1,0,0},
        //     {0,0,0,0,0,0,0,1,1,1,0,0,0},
        //     {0,0,0,0,0,0,0,1,1,0,0,0,0}
        // };

        // int[][] grid = {
        //     {0,0,1},
        //     {1,0,1},
        //     {0,0,1}
        // };

        // int[][] grid = {
        //     {1}
        // };

        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static boolean seen[][];
    public static int m;
    public static int n;
    public static int tempAns;

    public static int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        int ans = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                dfs(i, j, grid);
                ans = Math.max(ans, tempAns);
                tempAns = 0;
            }
        }

        return ans;
    }

    public static boolean valid(int row, int column, int[][]grid){

        return 0 <= row && row < m && 0 <= column && column < n && grid[row][column] == 1;
    }

    public static void dfs(int row, int column, int[][]grid){

        if(grid[row][column] == 1 && !seen[row][column]){
            tempAns++;
        }

        for(int[] direction: directions){

            int nextRow = row + direction[0];
            int nextCol = column + direction[1];

            if(valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]){

                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }
}
