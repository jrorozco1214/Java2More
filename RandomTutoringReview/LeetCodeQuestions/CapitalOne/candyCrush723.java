package LeetCodeQuestions.CapitalOne;

public class candyCrush723 {

    public static void main(String[] args) {

        // candyCrush(new int[][]{
        //     {5,6,5,5,6,5},
        //     {4,3,2,1,2,2},
        //     {2,1,1,1,1,2},
        //     {3,2,3,1,3,2},
        // });

        candyCrush(new int[][]{
            {0, 5, 5, 0},
            {0, 3, 3, 5},
            {3, 4, 4, 4},
        });
    }

    public static int[][] candyCrush(int[][] board) {

        printBoard(board);
        System.out.println();

        boolean didChange = tryCrush(board);

        while(didChange){


            didChange = tryCrush(board);
        }

        return board;
    }

    public static void printMarked(boolean[][] marked){

        for(boolean[] row: marked){

            for(boolean element: row){

                if(element == true){

                    System.out.print("_ ");
                } else {

                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void printBoard(int[][] board){

        for(int[] row: board){

            for(int element: row){

                if(element == 0){

                    System.out.print("_ ");
                } else {

                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }



    public static boolean tryCrush(int[][] board) {

        //going horizontally
        int rows = board.length;
        int columns = board[0].length;

        boolean[][] marked = new boolean[rows][columns]; 

        for(int i = 0; i < rows; i++){

            int streak = 1;

            for(int j = 1; j < columns; j++){

                if(board[i][j] == board[i][j-1]){

                    streak++;

                } else {

                    if(streak >= 3){

                        int streakStart = j - streak;

                        for(int j2 = streakStart; j2 < j; j2++){

                            marked[i][j2] = true;
                        }
                    }
                    streak = 1;
                }
            }

            if(streak >= 3){

                int streakStart = columns - streak;

                for(int j2 = streakStart; j2 < columns; j2++){

                    marked[i][j2] = true;
                }
            }
        }

        //vertical traversal
        for(int j = 0; j < columns; j++){

            int streak = 1;
            for(int i = 1; i < rows; i++){

                if(board[i][j] == board[i-1][j]){

                    streak++;

                } else {

                    if(streak >= 3){

                        int streakStart = i - streak;

                        for(int i2 = streakStart; i2 < i; i2++){

                            marked[i2][j] = true;
                        }
                    }
                    streak = 1;
                }
            }

            if(streak >= 3){

                int streakStart = rows - streak;

                for(int i2 = streakStart; i2 < rows; i2++){

                    marked[i2][j] = true;
                }
            }
        }

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < columns; j++){

                if(marked[i][j] == true){

                    board[i][j] = 0;
                }
            }
        }

        boolean didChange = false;

        for(int j = 0; j < columns; j++){

            int bottom = rows - 1;



            for(int top = rows - 1; top >= 0; top--){

                if(board[bottom][j] != 0){

                    bottom--;
                } else if(board[top][j] != 0){

                    System.out.println(bottom + " " + top);

                    board[bottom][j] = board[top][j];
                    board[top][j] = 0;
                    bottom--;

                    didChange = true;
                }
            }

            printBoard(board);
            System.out.println();
        }

        printBoard(board);
        System.out.println();

        return didChange;
    }
    
}
