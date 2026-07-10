package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;

import LeetCodeQuestions.TreesAndGraphs.maximumDifferenceBetweenNodeAndAncestor1026.TreeNode;



public class rangeSumofBst938 {

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

        TreeNode t1 = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        TreeNode t2 = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)), new TreeNode(15, new TreeNode(13), new TreeNode(18)));

        System.out.println(rangeSumBST(t2, 6, 10));
    }


    public static int rangeSumBST(TreeNode root, int low, int high) {

        int total = 0;

        return helperRangeSumBST(root, low, high, total);
    }

    public static int helperRangeSumBST(TreeNode root, int low, int high, int total){

        if(root == null){

            return total;
        }


        total = helperRangeSumBST(root.left, low, high, total);
        total = helperRangeSumBST(root.right, low, high, total);

        if(root.val >= low && root.val <= high){

            total += root.val;
        }

        return total;
    }
}
