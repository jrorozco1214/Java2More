package StackDataStructure;

import TestPractice.Recursion.ar;

public class Stack {

private int maxSize;
private int []ar;
private int top;


public Stack(int maxSize){
    this.maxSize = maxSize;
    ar = new int[this.maxSize];
    top = -1;
}

public void push(int x){
    if(top == maxSize - 1){
        System.out.println("overload");
    } else {
        ar[++top] = x;
    }
}

public int pop(){

    if(top == -1){
        System.out.println("underload");
    }
        return ar[top--];
}

public void peek(){
    
    if(top == -1){
        System.out.println("there is nothing on top of the stack");
    } else {
        System.out.println(ar[top]);
    }
}

public void sizeOfStack(){
    if(top == -1){
        System.out.println("empty");
    } else {
        System.out.println(top + 1);
    }
}

public void ifEmpty(){
    if(top == -1){
        System.out.println(true);
    } else {
        System.out.println(false);
    }
}

    
}
