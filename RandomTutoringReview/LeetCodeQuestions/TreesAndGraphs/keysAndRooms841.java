package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class keysAndRooms841 {

    public static void main(String[] args) {

        List<List<Integer>> x = new ArrayList<>();
        x.add(new ArrayList<>(List.of(1)));
        x.add(new ArrayList<>(List.of(2)));
        x.add(new ArrayList<>(List.of(3)));
        x.add(new ArrayList<>(List.of()));

        canVisitAllRooms(x);

    }

    public static Set<Integer> seen = new HashSet<>();
    
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen.add(0);
        dfs(0, rooms);

        return seen.size() == rooms.size();
    }
    
    public static void dfs(int node, List<List<Integer>>rooms) {
        for (int neighbor: rooms.get(node)) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                dfs(neighbor, rooms);
            }
        }
    }
    
}
