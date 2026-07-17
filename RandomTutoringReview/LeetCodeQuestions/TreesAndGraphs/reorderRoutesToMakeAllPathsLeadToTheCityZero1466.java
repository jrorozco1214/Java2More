package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class reorderRoutesToMakeAllPathsLeadToTheCityZero1466 {

    public static void main(String[] args) {

        int[][] a = {
            {0,1}, {2,1}, {3,0}
        };
        minReorder(4, a);
    }

    public static Set<String> roads = new HashSet<>();
    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static Set<Integer> seen = new HashSet<>();

    public static int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] connection: connections) {
            int x = connection[0], y = connection[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
            roads.add(convertToHash(x, y));
        }

        seen.add(0);
        return dfs(0);   
    }

    public static int dfs(int node) {
        int ans = 0;
        for (int neighbor: graph.get(node)) {
            if (!seen.contains(neighbor)) {
                if (roads.contains(convertToHash(node, neighbor))) {
                    ans++;
                }

                seen.add(neighbor);
                ans += dfs(neighbor);
            }
        }
        
        return ans;
    }

    public static String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }
 
}
