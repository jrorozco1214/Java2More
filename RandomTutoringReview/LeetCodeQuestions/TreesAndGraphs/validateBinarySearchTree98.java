package LeetCodeQuestions.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


public class validateBinarySearchTree98 {

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

        //TreeNode t1 = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), null)), new TreeNode(10));
        TreeNode t2 = new TreeNode(5, new TreeNode(4, null, null), new TreeNode(6, new TreeNode(3), new TreeNode(7)));

        System.out.println(isValidBST(t2));
        
    }

    public static boolean isValidBST(TreeNode root) {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean checkNode(TreeNode node, int min, int max) {
        if (node == null){
            return true;
        }
        if(node.val > min && node.val < max){
            return (checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max));
        } else {
            return false;
        }
    }
}
