package LeetCodeQuestions.TreesAndGraphs;

public class wordSearch79 {
    
    public static void main(String[] args) {

        System.out.println(exist(new char[][]{
                                            {'A', 'B', 'C', 'E'},
                                            {'S', 'F', 'C', 'S'},
                                            {'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }

    public static boolean[][] visited;
    public static int[][] coords = {{0,1},{1,0},{-1,0},{0,-1}};
    public static int m;
    public static int n;
    public static int ansCount = 0;
    public static int temp = 0;

    public static boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        int tempCount = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(board[i][j] == word.charAt(0)) {

                    dfs(board, word, i, j, tempCount);

                    if(ansCount == word.length()) {

                        return true;
                    } else {

                        visited = new boolean[m][n]; 
                    }
                }
            }
        }

        return false;
    }

    public static boolean valid(int nextX, int nextY) {

        return 0 <= nextX && nextX < m && 0 <= nextY && nextY < n;
    }

    public static void dfs(char[][]board, String word, int currX, int currY, int tempCount) {

        if(tempCount == word.length()){

            ansCount = tempCount;
            return;
        }

        if(word.charAt(tempCount) != board[currX][currY] || visited[currX][currY]) {

            return;
        }
        
        visited[currX][currY] = true; 
        tempCount++;

        for(int[] updateCords: coords) {

            int nextX = updateCords[0] + currX;
            int nextY = updateCords[1] + currY;

            if(valid(nextX, nextY) && !visited[nextX][nextY]) {

                dfs(board, word, nextX, nextY, tempCount);
            }
        }
        tempCount--;

    }
}
