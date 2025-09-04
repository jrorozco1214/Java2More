package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack and returns it.
    public int pop() {
        int size = q.size();
        // Rotate until only the last element is left
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    // Get the top element.
    public int top() {
        int size = q.size();
        // Rotate until last element is at front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        int top = q.peek();  // get front
        q.add(q.remove());   // put it back
        return top;
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
