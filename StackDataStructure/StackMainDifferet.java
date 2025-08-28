package StackDataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class StackMainDifferet {
    public static void main(String[] args) {
        
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(10);
        stack.push(7);

        stack.peek();
        stack.pop();

        stack.sizeOfStack();
        stack.ifEmpty();

    }
}
