package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();

        queue.offer("Karen"); //adding to the queue, will return false if it fails
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        queue.poll(); //removing from the head, .poll() will not throw an exception
        queue.poll();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
    }
    
}
