package DataStructures;

public class MyQueueMain {
    public static void main(String[] args) {
        
    MyQueue m1 = new MyQueue();

    m1.enqueue(5);
    m1.enqueue(7);

    System.out.println(m1.toString());
    m1.enqueue(9);
    System.out.println(m1.toString());

    m1.dequeue();
    
    System.out.println(m1.toString());

    }
    
}
