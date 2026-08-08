package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal102 {

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

        //System.out.println(levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(levelOrder(null));
    }

    public static List<List<Integer>> levelOrder(TreeNode root){

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp;

        if(root == null) {

            return result;
        }
        
        temp = new ArrayList<>();
        temp.add(root.val);

        result.add(temp);

        while(!q.isEmpty()) {

            int size = q.size();
            

            for(int i = 0; i < size; i++) {

                TreeNode node = q.remove();

                if(node.left != null) {

                    q.add(node.left);
                }

                if(node.right != null) {

                    q.add(node.right);
                }
            }

            if(!q.isEmpty()) {
                temp = new ArrayList<>();

                for(TreeNode node: q) {
              
                    temp.add(node.val);
                }

                result.add(temp);
            }
        }

        return result;
    }
}
