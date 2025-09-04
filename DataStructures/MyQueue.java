package DataStructures;

import java.util.Stack;

public class MyQueue { //
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackReversed = new Stack<>();

  public void enqueue(int x) { 
    stack.push(x);
  }

  public int dequeue() {

    while(!stack.isEmpty()){
    stackReversed.push(stack.pop());
    }

    int top = stackReversed.pop();

    while(!stackReversed.isEmpty()){
        stack.push(stackReversed.pop()); //resets the stack
    }

    return top;
  }

  public String toString(){
    return "MyQueuep[stack = " + stack + "]";
  }
}
