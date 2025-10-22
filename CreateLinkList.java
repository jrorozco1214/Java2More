import java.util.LinkedList;

public class CreateLinkList {
    Node head;

    // Node definition
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to append a node at the end
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        } //the pointer is getting deleted each time so a looped is needed inorder to find the end
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new_node;
    }

    // Function to rotate the list to the right by k nodes
    public void rotate(int k) {
        if (head == null || k == 0)
            return;

        // Count the number of nodes
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Connect last node to head to make it circular
        temp.next = head;

        // Normalize k (in case k > length)
        k = k % length;
        int stepsToNewHead = length - k;

        // Move to the new head
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // The node next to newTail will be the new head
        head = newTail.next;

        // Break the loop
        newTail.next = null;
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main function to test the rotation
    public static void main(String[] args) {
        CreateLinkList list = new CreateLinkList();

        // Create list: 10 -> 20 -> 30 -> 40 -> 50 -> 60
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        list.append(60);

        System.out.println("Original Linked List:");
        list.printList();

        int k = 2;
        list.rotate(k);

        System.out.println("Rotated Linked List by " + k + " positions:");
        list.printList();
    }
}
