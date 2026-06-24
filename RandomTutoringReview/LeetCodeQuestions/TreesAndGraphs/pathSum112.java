

public class pathSum112 {

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

        TreeNode tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));


        System.out.println(hasPathSum(tree, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        int current = 0;


        return dfs(root, 0, targetSum);
    }

    public static boolean dfs(TreeNode node, int current, int targetSum){

        if(node == null){
            return false;
        }

        if(node.left == null && node.right == null){
            return (current + node.val) == targetSum;
        }

        current += node.val;
        boolean left = dfs(node.left, current, targetSum);
        boolean right = dfs(node.right, current, targetSum);

        return left || right;
    }
    
}
