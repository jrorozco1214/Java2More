package LeetCodeQuestions.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class findPlayersWithZeroOrOneLosses2225 {

    public static void main(String[] args) {

        findWinners(new int[][]{
            {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}
        });
    }

    public static List<List<Integer>> findWinners(int[][] matches) {

        HashSet<Integer> player = new HashSet<>();
        HashMap<Integer, Integer> loss = new HashMap<>();

        for(int[] x: matches){

            player.add(x[0]);
            player.add(x[1]);
        }
        
        for(Integer x: player){

            loss.put(x, 0);
        }

        for(int []x: matches){

            if(loss.containsKey(x[1])){

                loss.put(x[1],loss.getOrDefault(x[1], 0)+1);
            }
        }

        System.out.println(loss);

        return null;
    }

    // public static int[][] generateTwoD(int n, int m, int...numbers){

    //     int[][] twoD = new int[n][m];

    //     int z= 0;

    //     for(int i = 0; i < n; i++){

    //         for(int j = 0; j < m; j++){

    //             for(z; z < numbers.length; z++){

    //                 if(z % 2 == 1)
    //             }
    //         }
    //     }

    // }
}
