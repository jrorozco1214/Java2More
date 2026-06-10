package LeetCodeQuestions;

import java.util.List;

public class mergeTwoSortedList21 {
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

        // ListNode v1 = new ListNode(1);
        // ListNode v2 = new ListNode(2);
        // ListNode v3 = new ListNode(4);

        // v1.next = v2;
        // v2.next = v3;

        // ListNode vv1 = new ListNode(2);
        // ListNode vv2 = new ListNode(3);
        // ListNode vv3 = new ListNode(4);
        // vv1.next = vv2;
        // vv2.next = vv3;

        ListNode v1 = new ListNode(2);
        ListNode vv1 = new ListNode(1);

        ListNode result = mergeTwoSortedList(v1, vv1);

        ListNode temp = result;

        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println(result);
    }

    public static ListNode mergeTwoSortedList(ListNode list1, ListNode list2){

        ListNode head = new ListNode();
        ListNode traverse = null;

        ListNode p1 = list1;
        ListNode p2 = list2;

        //check if p1 and p2 are null and return either or 

        if(p1 == null && p2 == null) {

            return null;
        } else if (p1 == null && p2 != null) {

            return list2;
        } else if (p1 != null && p2 == null){

            return list1;
        }

        while(p1 != null && p2 != null){

            if(p1.val == p2.val){

                if(head.next == null){
                    
                    ListNode r1 = new ListNode(p1.val);
                    ListNode r2 = new ListNode(p2.val);

                    head = r1;
                    traverse = head;
                    traverse.next = r2;
                    traverse = r1.next;

                    p1 = p1.next;
                    p2 = p2.next;
                } else {

                    ListNode r1 = new ListNode(p1.val);
                    ListNode r2 = new ListNode(p2.val);

                    traverse.next = r1;
                    traverse = r1;
                    traverse.next = r2;
                    traverse = r1.next;

                    p1 = p1.next;
                    p2 = p2.next;
                }

            } else if(p1.val < p2.val){

                ListNode r3 = new ListNode(p1.val);

                if(p1.next == null && p2.next == null && head.val == 0){
                    head.val = p1.val;
                    head.next = p2;
                    return head;
                }

                if(traverse == null) {
                    traverse = head;
                    traverse.val = p1.val;
                    traverse = traverse.next;
                } else {
                    traverse.next = r3;
                    traverse = traverse.next;
                }

                p1 = p1.next;
            } else if(p1.val > p2.val){

                ListNode r4 = new ListNode(p2.val);

                if(p1.next == null && p2.next == null && head.val == 0){
                    head.val = p2.val;
                    head.next = p1;
                    return head;
                }

                if(traverse == null){
                    traverse = head;
                    traverse.val = p2.val;
                    traverse = traverse.next;
                } else {
                    traverse.next = r4;
                    traverse = traverse.next;
                }

                p2 = p2.next;
            }
        }
        return head;
    }
}