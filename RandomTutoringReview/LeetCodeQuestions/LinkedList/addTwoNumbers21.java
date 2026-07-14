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
    }

    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        ListNode result = addTwoNumbers(l1, l2);

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

            //if(carry >= 1)

            resultTail.next = new ListNode(resultDigit, null);
            resultTail = resultTail.next;
        }

        return resultHead.next;
    }
    
}
