package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintAllPage {
    
    private Queue<Integer> q1 = new LinkedList<>();
    static ArrayList<Integer> storage = new ArrayList<>();

    public void addTo(int x){
        q1.add(x);
    }

    public int removeFromHead(){
        return q1.remove();
    }

    public void multipleTwo() {
        int k = 2;
        int n = 0;

        for(int i = 0; i < q1.size() + n; i++){
            if(i % k == 1){
                storage.add(q1.remove());

            } else {
                q1.add(q1.remove());
            }
            n++;
        }
    }

    public static void checkList(){
        for(Integer i: storage){
            System.out.println(i);
        }
    }
}
