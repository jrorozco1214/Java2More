package LeetCodeQuestions.TreesAndGraphs;

public class wordSearch79 {
    
    public static void main(String[] args) {

        System.out.println(exist(new char[][]{
                                            {'A', 'B', 'C', 'E'},
                                            {'S', 'F', 'C', 'S'},
                                            {'A', 'D', 'E', 'E'}
        }, "ABCB"));

        System.out.println(exist(new char[][]{
                                            {'A', 'S', 'T', 'I'},
                                            {'S', 'T', 'A', 'C'},
                                            {'A', 'X', 'B', 'L'}
        }, "STATIC"));

        System.out.println(exist(new char[][]{
                                            {'a'},
        }, "a"));
    }

    public static boolean[][] visited;
    public static int[][] coords = {{0,1},{1,0},{-1,0},{0,-1}};
    public static int m;
    public static int n;
    public static boolean result = false;


    public static boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(board[i][j] == word.charAt(0)) {

                    dfs(board, word, i, j, 0);

                    if(result) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean valid(int nextX, int nextY) {

        return 0 <= nextX && nextX < m && 0 <= nextY && nextY < n;
    }

    public static void dfs(char[][]board, String word, int currX, int currY, int letterIndex) {


        if(word.charAt(letterIndex) != board[currX][currY] || visited[currX][currY]) {

            return;
        }

        if(letterIndex+1 == word.length()){

            result = true;
            return;
        }
        
        visited[currX][currY] = true; 

        for(int[] updateCords: coords) {

            int nextX = updateCords[0] + currX;
            int nextY = updateCords[1] + currY;

            if(valid(nextX, nextY)) {

                dfs(board, word, nextX, nextY, letterIndex+1);
                
                if(result) {

                    break;
                }
            }
        }
        visited[currX][currY] = false;

    }
}
