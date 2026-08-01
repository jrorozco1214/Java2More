package LeetCodeQuestions.BinarySearch;

public class pathWithMinimumEffort1631 {

    public static void main(String[] args) {

        System.out.println(minimumEffortPath(new int[][]{
            {1,10,6,7,9,10,4,9}
        }));
    }

    public static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static boolean[][] adjMatrix;
    public static int m;
    public static int n;

    public static int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        m = heights.length;
        n = heights[0].length;

        int result = right; 

        while(left <= right){

            int mid = left + (right - left) / 2;
            adjMatrix = new boolean[m][n];

            if(dfs(0,0,mid, heights)){

                result = Math.min(result, mid);
                right = mid - 1;
                
            } else {

                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean dfs(int row, int column, int mid, int[][]heights) {

        if(row == m - 1 && column == n - 1){

            return true;
        }
        adjMatrix[row][column] = true;

         for(int[] direction: directions) { 

            int nextRow = row + direction[0];
            int nextCol = column + direction[1];

            if(isValid(nextRow, nextCol) && !adjMatrix[nextRow][nextCol]) {

                int difference = Math.abs(heights[nextRow][nextCol] - heights[row][column]);

                if(difference <= mid){

                    if(dfs(nextRow, nextCol, mid, heights)) {

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isValid(int nextRow, int nextCol){ //does it fall in the grid

        return 0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n; 
    }
}
