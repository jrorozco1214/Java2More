package LeetCodeQuestions;

public class swapNodesInPairs24 {

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


        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        head = dummy;


        ListNode p1 = dummy.next;
        ListNode p2 = p1.next;

        dummy.next = p2;
        p1.next = null;
        p1.next = p2.next;
        p2.next = p1;

        p1 = p2;
        p2 = p1.next;

        while(p1.next != null && p2.next != null){

            p1.next = p2.next;
            p1 = p1.next;
            p1.next = p2;
            p2.next = null;
            
        }
        
        if(p2 == null){
            return head;
        } else if(p2.next == null){
            p1.next = null;

            p2.next = p1;

            return head;
        }



        return head;
    } 
}
