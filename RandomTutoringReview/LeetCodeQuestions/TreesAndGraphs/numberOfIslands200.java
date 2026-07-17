package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class numberOfIslands200 {

    public static void main(String[] args) {
        
        char[][] x = {{'1','1','1','1','0'},
                      {'1','1','0','1','0'},
                      {'1','1','0','0','0'},
                      {'0','0','0','0','0'}
        };

        System.out.println(numIslands(x));
    }

    public static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static boolean[][] seen;
    public static int m;
    public static int n;

    public static int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        for(int row = 0; row < m; row++){

            for(int col = 0; col < n; col++){

                if(grid[row][col] == '1' && !seen[row][col]){

                    ans++;
                    seen[row][col] = true;
                    dfs(row, col, grid);
                }
            }
        }
        
        return ans;
    }

    public static boolean valid(int row, int col, char[][] grid){

        return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
    }

    public static void dfs(int row, int col, char[][] grid) {
        for (int[] direction: directions) {

            int nextRow = row + direction[0], nextCol = col + direction[1];

            if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                
                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }
}
