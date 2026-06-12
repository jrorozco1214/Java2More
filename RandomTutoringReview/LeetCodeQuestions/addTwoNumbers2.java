package LeetCodeQuestions;

import java.math.BigInteger;
import java.util.Stack;

public class addTwoNumbers2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
            
        }
        ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));

        ListNode finalList = addTwoNumbers(l1, l2);

        ListNode temp = finalList;

        while (temp.next != null) {
            System.out.println(temp.val);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> list1 = new Stack<>();
        Stack<Integer> list2 = new Stack<>();

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null){

            list1.push(p1.val);
            p1 = p1.next;
        }
        
        while(p2 != null){

            list2.push(p2.val);
            p2 = p2.next;
        }

        System.out.println(list1.size());
        System.out.println(list2.size());

        String num1 = "";
        String num2 = "";

        int stackSize1 = list1.size();
        int stackSize2 = list2.size();

        for(int i = 0; i < stackSize1; i++){

            num1 = num1 + list1.pop();
        }

        for(int i = 0; i < stackSize2; i++){
            num2 = num2 + list2.pop();
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);
        
        number1 = number1.add(number2);

        long result = Long.parseLong(num1) + Long.parseLong(num2);


        // if(result == 0){
        //     return new ListNode(0);
        // }

        if(number1.longValue() == 0){
            return new ListNode(0);
        }

        ListNode head = null;
        ListNode temp = null;

        while(number1.longValue() > 0){
            long singleValue = number1.longValue() % 10;

        }

        // while(result > 0){

        //     long singleValue = result % 10;
        //     result = result / 10;


        //     if(head == null){

        //         head = new ListNode((int)singleValue);
        //         temp = head;
        //     } else {

        //         temp.next = new ListNode((int)singleValue);
        //         temp = temp.next;
        //     }
        // }
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(result);



        return head;
    }
    
}
