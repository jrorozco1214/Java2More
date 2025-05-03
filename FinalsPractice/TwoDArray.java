package FinalsPractice;

import java.util.Arrays;

public class TwoDArray {

public static void main(String[] args) {
    int [][] ar = new int[4][4];

    for(int i = 0; i < ar.length; i++){

        int total = 0;

        for(int j = 0; j <ar[0].length; j++){
            total++;
            ar[i][j] = total;
        }
    }

    System.out.print(Arrays.deepToString(ar));
    }
    
}
