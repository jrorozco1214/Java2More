package LeetCodeQuestions.TreesAndGraphs;

public class diameterOfBinaryTree543 {

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

        //TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, null, new TreeNode(6))), new TreeNode(3));
        //TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        //TreeNode t3 = new TreeNode(1, new TreeNode(2), null);

        TreeNode t4 = new TreeNode(-4, new TreeNode(-7), new TreeNode(-3, new TreeNode(-9, new TreeNode(9, new TreeNode(6, new TreeNode(0, new TreeNode(9), new TreeNode(-1)), new TreeNode(6)), null), new TreeNode(-7, new TreeNode(-6, new TreeNode(5), null), new TreeNode(-6, null, new TreeNode(-2)))), new TreeNode(-3)));

        System.out.println(diameterOfBinaryTree(t4));
    }


    public static int diameterOfBinaryTree(TreeNode root) {

        int left = helperDiameterOfBinaryTree(root.left, 0, 0);
        int right = helperDiameterOfBinaryTree(root.right, 0, 0);

        return (left + right);
    }

    public static int helperDiameterOfBinaryTree(TreeNode root, int left, int right){

        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){

            return 1;
        }

        left  = helperDiameterOfBinaryTree(root.left, left, right);
        right = helperDiameterOfBinaryTree(root.right, left, right);

        // if(left >= right){
        //     return left + 1;
        // }

        // return right + 1;

        return Math.max(left, right)+1;

    }
}
