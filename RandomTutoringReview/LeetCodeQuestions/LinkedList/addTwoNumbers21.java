package LeetCodeQuestions.LinkedList;

import java.util.List;

public class addTwoNumbers21 {

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

        @Override
        public String toString(){


            return "ListNode [" + val + ", " + next + "]"; //recursively call for next and will do val + ", " + next again and again
        }

        public static ListNode inputValue(int... array) {

            ListNode head = new ListNode(array[0]);
            ListNode tail = head;

            for(int i = 1; i < array.length; i++){

                tail.next = new ListNode(array[i]);
                tail = tail.next;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        
        // ListNode l1 = new ListNode(4, new ListNode(9, null));
        // ListNode l2 = new ListNode(2, new ListNode(1, null));

        // ListNode result = addTwoNumbers();

        // System.out.println(result.toString());

        ListNode t1 = ListNode.inputValue(9,9,9,9,9,9,9);
        ListNode t2 = ListNode.inputValue(9,9,9,9);

        ListNode result = addTwoNumbers(t1, t2);

        System.out.println(result.toString());

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode n1 = l1;
        ListNode n2 = l2;

        ListNode resultHead = new ListNode(0, null);
        ListNode resultTail = resultHead;

        int carry = 0;


        while(n1 != null && n2 != null){

            int sum = carry + n1.val + n2.val;
            int resultDigit = sum % 10;
            carry = sum / 10;

            resultTail.next = new ListNode(resultDigit, null);
            resultTail = resultTail.next;

            n1 = n1.next;
            n2 = n2.next;
        }

        while(n1 != null) {

            int sum = carry + n1.val;
            int resultDigit = sum % 10;
            carry = sum / 10;

            resultTail.next = new ListNode(resultDigit, null);
            resultTail = resultTail.next;

            n1 = n1.next;

        }

        while(n2 != null){

            int sum = carry + n2.val;
            int resultDigit = sum % 10;
            carry = sum / 10;

            resultTail.next = new ListNode(resultDigit, null);
            resultTail = resultTail.next;

            n2 = n2.next;
        }

        if(carry >= 1){

            resultTail.next = new ListNode(carry, null);
            resultTail = resultTail.next;
        }

        return resultHead.next;
    }
    
}
