package LeetCodeQuestions.TreesAndGraphs;
public class maximumDifferenceBetweenNodeAndAncestor1026 {

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

        TreeNode t1 = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))), new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

        System.out.println(maxAncestorDiff(t1));
    }

    public static int maxAncestorDiff(TreeNode root) {

        int lMin = minofSubtree(root.left);
        int lMax = maxOfSubtree(root.left);
        
        lMin = Math.min(root.val, lMin);
        lMax = Math.max(root.val, lMax);

        int rMin = minofSubtree(root.right);
        int rMax = maxOfSubtree(root.right);

        rMin = Math.min(root.val, rMin);
        rMax = Math.max(root.val, rMax);

        int finalMin = Math.abs(lMin - lMax);
        int finalMax = Math.abs(rMin - rMax);

        if(finalMin > finalMax){
            return finalMin;
        }

        return finalMax;
    }

    public static int minofSubtree(TreeNode root){

        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.val;
        }

        int left = minofSubtree(root.left);
        int right = minofSubtree(root.right);

        int minTemp = Math.min(left, right);

        return Math.min(root.val, minTemp);
    }

    public static int maxOfSubtree(TreeNode root){

        if(root == null){
            return Integer.MIN_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.val;
        }

        int left = maxOfSubtree(root.left);
        int right = maxOfSubtree(root.right);

        int maxTemp = Math.max(left, right);

        return Math.max(root.val, maxTemp);
    }
    
}
