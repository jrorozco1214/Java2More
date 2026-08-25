package LeetCodeQuestions.LinkedList;

import java.util.Stack;

public class removeNthNodeFromEndOfList19 {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public static void main(String[] args) {
        
        
        removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 2);
        removeNthFromEnd(new ListNode(1), 1);
        removeNthFromEnd(new ListNode(1, new ListNode(2, null)), 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int counter = 0;
        ListNode traverse = head;
        
        Stack<ListNode> reverse = new Stack<>();

        ListNode traverseHead = null;
        while(traverse != null){

            if(reverse.size() <= 0){

                ListNode node = new ListNode(traverse.val);
                ListNode reverseHead = node;
                traverseHead = reverseHead;
            }

            ListNode node = new ListNode(traverse.val);

            traverseHead.next = node;
            traverse = traverse.next;
        }

        ListNode reverseHead = reverse;

        traverse = head;

        for(int i = 1; i <= reverse.size(); i++){

            if(i == n-1){

                if(traverse.next.next != null){

                    traverse = traverse.next.next;
                }else {

                    traverse = traverse.next;
                }
            } else {

                traverse = traverse.next;
            }
        }

        // while(traverse != null) {

        //     counter++;
        //     traverse = traverse.next;
        // }

        // if(counter <= 1) {

        //     return null;
        // }

        // traverse = head;

        // if(counter >= n) {

        //     int track = 0;

        //     while(track < n) {

        //         track++;
        //         traverse = traverse.next;
        //     }
            
        //     if(traverse.next == null){

        //         head.next = null;
        //         return head;
        //     }

        //     if(traverse.next.next != null) {

        //         traverse.next = traverse.next.next;
        //     } else {

        //         traverse.next = null;
        //     }
        // }

        return head;
    }
    
}
