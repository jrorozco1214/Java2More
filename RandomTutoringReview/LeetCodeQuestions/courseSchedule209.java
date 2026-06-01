package LeetCodeQuestions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class courseSchedule209 {
    public static void main(String[] args) {

        System.out.println(canFinish(4, new int[][] {{3,1},{2,3},{0,2},{1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>(); 

        int[] numDeps = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){

            int blocked = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            
            numDeps[blocked]++;

            if(!adjList.containsKey(prereq)){

                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(blocked);
                adjList.put(prereq, temp);
            } else {

                adjList.get(prereq).add(blocked);
            }
        }

        Queue<Integer> potCourses = new LinkedList<Integer>();

        for(int i = 0; i < numDeps.length; i++){

            if(numDeps[i] == 0){

                potCourses.add(i);
            }
        }

        int counter = 0;

        while(!potCourses.isEmpty()) {

            int head = potCourses.remove();
            counter++;

            if(!adjList.containsKey(head)){
                continue;
            }

            ArrayList<Integer> blockedList = adjList.get(head);

            for(Integer id: blockedList){

                numDeps[id]--;

                if(numDeps[id] == 0){
                    potCourses.add(id);
                }
            }
        }

        return counter == numCourses;
    }
    
}
