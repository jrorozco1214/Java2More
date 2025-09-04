package DataStructures;

public class MyStackMain {

    public static void main(String[] args) {
        MyStack q = new MyStack();

        q.push(12);
        q.push(4);
        q.push(3);

        System.out.println(q.pop());

        System.out.println(q);
    }
    
}
