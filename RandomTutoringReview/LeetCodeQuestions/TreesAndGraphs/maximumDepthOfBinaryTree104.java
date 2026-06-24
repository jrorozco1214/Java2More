

public class maximumDepthOfBinaryTree104 {

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

        // TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, null, new TreeNode(5, null, new TreeNode(6))));

        maxDepth(root);
    }

    public static int maxDepth(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;

    }
}
