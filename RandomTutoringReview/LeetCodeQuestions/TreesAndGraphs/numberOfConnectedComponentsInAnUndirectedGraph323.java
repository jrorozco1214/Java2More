package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class numberOfConnectedComponentsInAnUndirectedGraph323 {

    public static void main(String[] args) {

        int[][] x = {
            {0,1},{1,2},{2,3},{3,4}
        };
        System.out.println(countComponents(5, x));
    }

    public static Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    public static Set<Integer> seen = new HashSet<>();

    public static int countComponents(int n, int[][] edges) {

        for(int i = 0; i < n; i++){

            adj.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){

            int x = edge[0];
            int y = edge[1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int ans = 0;
        int i = 0;

        while(seen.size() < n){

            if(!seen.contains(i)){

                dfs(i);
                ans++;
            }
            i++;
        }

        return ans;
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
