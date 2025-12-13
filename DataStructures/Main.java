package DataStructures;
// A simple Queue interface

import LQueue;
import Link;
import Queue;

interface Queue<T> {
    boolean enqueue(T item);   // Add element at the rear
    T dequeue();               // Remove element from front
    T frontValue();            // Peek at front element
    int length();              // Return number of elements
    boolean isEmpty();         // Check if queue is empty
}

// Node class for the linked queue
class Link<T> {
    private T element;
    private Link<T> next;

    // Constructor for a normal node
    Link(T element, Link<T> next) {
        this.element = element;
        this.next = next;
    }

    // Getters and setters
    public T element() { 
        return element; 
    }
    public Link<T> next() { 
        return next; 
    }
    public void setNext(Link<T> next) { 
        this.next = next; 
    }
}

// Linked queue implementation
class LQueue<T> implements Queue<T> { //T stands for type and can work with any data type
    private Link<T> front;  // Pointer to front dummy node
    private Link<T> rear;   // Pointer to last node
    private int size;       // Number of elements in queue

    // Constructors
    LQueue() { 
        init(); 
    }
    LQueue(int ignoredSize) { 
        init(); 
    } // Ignore size parameter

    // Initialize the queue
    private void init() {
        front = rear = new Link<>(null, null); // Create dummy node
        size = 0;
    }

    // Enqueue: add element to the rear
    @Override
    public boolean enqueue(T item) {
        rear.setNext(new Link<>(item, null)); // Add new node at rear
        rear = rear.next();                   // Move rear pointer
        size++;
        return true;
    }

    // Dequeue: remove and return element from front
    @Override
    public T dequeue() {
        if (size == 0) return null;
        T item = front.next().element();           // Get first element
        front.setNext(front.next().next());        // Remove it if nothing is present after next next it will be null
        if (front.next() == null) {
            rear = front;
        }    // If queue becomes empty
        size--;
        return item;
    }

    // Return front element without removing it
    @Override
    public T frontValue() {
        if (size == 0) return null;
        return front.next().element();
    }

    // Return queue size
    @Override
    public int length() {
        return size;
    }

    // Check if queue is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        LQueue<Integer> queue = new LQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.frontValue()); // 10
        System.out.println("Dequeued: " + queue.dequeue());  // 10
        System.out.println("Front after dequeue: " + queue.frontValue()); // 20
        System.out.println("Queue size: " + queue.length()); // 2
    }
}

