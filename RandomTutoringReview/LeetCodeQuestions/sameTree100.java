package LeetCodeQuestions;


public class sameTree100 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {


        // TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(8));
        // TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(8));

        // TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
        // TreeNode t4 = new TreeNode(1, null, new TreeNode(2));

        // TreeNode t5 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        // TreeNode t6 = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        // TreeNode t7 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(6, new TreeNode(8), new TreeNode(9))), new TreeNode(5));
        // TreeNode t8 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(6, new TreeNode(7), new TreeNode(9))), new TreeNode(5));

        TreeNode t9 = new TreeNode(1, null, new TreeNode(2, new TreeNode(4, null, new TreeNode(3)), null));
        TreeNode t10 = new TreeNode(1, null, new TreeNode(4, new TreeNode(2, null, new TreeNode(3)), null));


        //System.out.println(isSameTree(t1, t2));

        System.out.println(isSameTree(t9, t10));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        if(p != null && q == null || p == null && q != null){
            return false;
        }

        if(p.left == null && p.right == null && q.left == null && q.right == null){

            return p.val == q.val;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        if(left == right && p.val == q.val){
            return left || right ;
        }

        return left && right;

        // if (p == null && q == null) {
        //     return true;
        // }
        
        // if (p == null || q == null) {
        //     return false;
        // }
        
        // if (p.val != q.val) {
        //     return false;
        // }
        
        // boolean left = isSameTree(p.left, q.left);
        // boolean right = isSameTree(p.right, q.right);
        // return left && right;
    }
}