package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class graphSampleCode {
    public static void main(String[] args) {
        int[][] x = {{1,1,0}, {1,1,0}, {0,0,1}};

        findCircleNum(x);
    }

    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static boolean[] seen;

    public static int findCircleNum(int[][] isConnected) {
    // build the graph
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {

            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }

            for (int j = i + 1; j < n; j++) {

                if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                }

                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        seen = new boolean[n];
        int ans = 0;  
          
        for (int i = 0; i < n; i++) {

            if (!seen[i]) {
                // add all nodes of a connected component to the set
                ans++;
                seen[i] = true;
                dfs(i);
            }
        }
        
        return ans;
    }
    
    public static void dfs(int node) {

        for (int neighbor: graph.get(node)) {

            if (!seen[neighbor]) {

                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    } 
}
