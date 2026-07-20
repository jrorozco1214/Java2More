package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findIfPathExistsInGraph1971 {

    public static void main(String[] args) {
        int[][] edges = {
            {0,1},{0,2},{3,5},{5,4},{4,3}
        };


        System.out.println(validPath(6, edges, 0, 5));
    }

    public static HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    public static Set<Integer> seen = new HashSet<>();

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        for(int i = 0; i < n; i++){

            adj.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){

            int x = edge[0];
            int y = edge[1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        seen.add(source);
        dfs(source);
        
        return seen.contains(destination);
    }

    public static void dfs(int node){

        for(int neighbor: adj.get(node)){

            if(!seen.contains(neighbor)){

                seen.add(neighbor);
                dfs(neighbor);
            }
        }
    }
}
