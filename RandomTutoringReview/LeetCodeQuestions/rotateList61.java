package LeetCodeQuestions;

public class rotateList61 {
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
        
        ListNode v1 = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,null)))));
        ListNode v2 = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        ListNode v3 = new ListNode(1, new ListNode(2, new ListNode(3, null)));

        ListNode result = rotateRight(v3, 2_000_000_000);

        ListNode temp = result;

        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }

        //System.out.println(4 % 2_000_000_000);
    }

    public static ListNode rotateRight(ListNode head, int k){

        ListNode temp1;
        ListNode temp2;

        ListNode trav = head;

        int size = 1;
        while(trav.next != null){
            trav = trav.next;
            size++;
        }

        for(int i = 0; i < k % size; i++){
            temp1 = head;

            while(temp1.next.next != null){

                temp1 = temp1.next;
            }

            temp2 = temp1.next;
            temp1.next = null;

            temp2.next = head;
            head = temp2;
            
        }

        return head;
    }
}
