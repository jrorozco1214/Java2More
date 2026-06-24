

public class minimumDepthOfBinaryTree111 {

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
        
        TreeNode t1 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null)))));
        TreeNode t2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        System.out.println(minDepth(t2));
    }

    public static int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left <= 0){

            return right+=1;
        }

        if(right <= 0){
            return left+=1; 
        }

        return Math.min(left, right) + 1;
    }
}
