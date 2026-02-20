import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class MessageRoute {
//Breathe for search https://cses.fi/problemset/task/1667
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);


        int n = s.nextInt();
        int m = s.nextInt();

        int ar[][] = new int[m][2];

        for(int i = 0; i < ar.length; i++){

            ar[i][0] = s.nextInt();
            ar[i][1] = s.nextInt();
        }

        LinkedList<Integer> nodes = new LinkedList<>(); //link list is ac

        nodes.add(1);

        HashSet<Integer> visitedNodes = new HashSet<>();

        visitedNodes.add(1);

        HashMap<Integer,Integer> previousNodes = new HashMap<>();

        boolean foundValue = false;

        while(!nodes.isEmpty()){

            int current = nodes.remove();

            if(current == m){
                System.out.println("Found");
                foundValue = true;
                break;
            }


            for(int i = 0; i < ar.length; i++){

                if(ar[i][0] == current){
                    if(!visitedNodes.contains(ar[i][1])){
                        nodes.add(ar[i][1]);
                        visitedNodes.add(ar[i][1]);
                        previousNodes.put(ar[i][1], current);
                    }
                } else if(ar[i][1] == current){
                    if(!visitedNodes.contains(ar[i][0])){
                        nodes.add(ar[i][0]);
                        visitedNodes.add(ar[i][0]);
                        previousNodes.put(ar[i][0], current);
                    }
                }
            }        
        }

        if(foundValue == false){
            System.out.println("IMPOSSIBLE");
        }
    }
    
}
