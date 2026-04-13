import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort{

    public record Edge(int sr, int dst){}

    public static void main(String[] args) {

        Edge[] edges = new Edge[]{

            new Edge(0, 1),
            new Edge(0, 7),
            new Edge(0, 4),
            new Edge(1, 3),
            new Edge(7, 3),
            new Edge(7, 8),
            new Edge(4, 8),
            new Edge(4, 2),
            new Edge(3, 2),
            new Edge(3, 6),
            new Edge(3, 5),
            new Edge(8, 5),
            
        };

        var adjacencyLIstReturn = adjacencyList(edges);

        var incomingNodes = calcIncomingNodes(edges);

        System.out.println(TopologicalSortAlgo(adjacencyLIstReturn, incomingNodes, 9));

        

        
    }

    public static ArrayList<Integer> TopologicalSortAlgo(HashMap<Integer, ArrayList<Integer>> adjacencyList, HashMap<Integer, Integer> incomingNodesList, int numNodes){

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> finishedList = new ArrayList<>();

        for(int i = 0; i < numNodes; i++){

            queue.add(i);

        }

        while(!queue.isEmpty()){

            int index = queue.remove();

            if(incomingNodesList.getOrDefault(index, 0) == 0){

                ArrayList<Integer> adjacencyValues = adjacencyList.getOrDefault(index, new ArrayList<>());

                for(Integer value: adjacencyValues){

                    int incomingValue = incomingNodesList.get(value);

                    incomingNodesList.put(value, incomingValue-1); //expressions for -- will be confusing
                }

                finishedList.add(index);
            } else {

                queue.add(index);
            }
        }

        return finishedList;
        
    }

    public static HashMap<Integer, ArrayList<Integer>> adjacencyList(Edge[] edges){

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
                 
        for(Edge e: edges){

            if(adjList.containsKey(e.sr)){

                adjList.get(e.sr).add(e.dst); //the get function automaticallys go into the arrayList

            } else {

                ArrayList<Integer> destination = new ArrayList<>();
                destination.add(e.dst);

                adjList.put(e.sr, destination);
            }
            
        }

        return adjList;

    }

    public static HashMap<Integer, Integer> calcIncomingNodes(Edge[] edges){
        
        HashMap<Integer, Integer> nodesIncoming = new HashMap<>();
         
        for(Edge e: edges){

            if(nodesIncoming.containsKey(e.dst)){
                int numIncoming = nodesIncoming.get(e.dst);

                nodesIncoming.put(e.dst, numIncoming+1);
            } else {

                nodesIncoming.put(e.dst, 1);
            }
            
        }

        return nodesIncoming;

    }
    
}