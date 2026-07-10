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
        TreeNode t2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));


        System.out.println(isValidBST(t2));
        
    }

    public static boolean isValidBST(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode n = q.remove();

                if(n.left == null && n.right == null){

                    continue;
                }

                if(n.left == null){
                  
                  continue;
                } else if(n.left != null && n.left.val < n.val){

                    q.add(n.left);
                } else if(n.left != null && n.left.val > n.val){
                  
                  return false;
                }

                if(n.right == null){
                  
                  continue;
                } else if(n.right != null && n.right.val > n.val){

                    q.add(n.right);
                } else if(n.right != null && n.right.val < n.val){
                  
                  return false;
                }
            }
        }
        return true;
    }
}
