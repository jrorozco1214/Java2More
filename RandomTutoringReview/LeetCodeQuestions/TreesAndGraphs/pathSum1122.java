package LeetCodeQuestions.TreesAndGraphs;


public class pathSum1122 {

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

        hasPathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), 
        new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22);

        hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(5)), 5);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        int runningSum = 0;
        runningSum += root.val;

        if(root.left == null && root.right == null){

            if(root.val == runningSum){

                return true;
            } else {

                return false;
            }
        }

        boolean leftDetermined = hHasPathSum(root.left, targetSum, runningSum);
        boolean rightDetermined = hHasPathSum(root.right, targetSum, runningSum);

        return leftDetermined || rightDetermined;
    }

    public static boolean hHasPathSum(TreeNode root, int targetSum, int runningSum){

        if(root == null) {

            return false;
        }

        if(root.left == null && root.right == null){

            runningSum += root.val;

            if(targetSum == runningSum){

                return true;
            }

            return false;
        }

        boolean left = hHasPathSum(root.left, targetSum, runningSum += root.val);
        runningSum -= root.val;

        boolean rigth = hHasPathSum(root.right, targetSum, runningSum += root.val);

        return left || rigth;
    }
}
