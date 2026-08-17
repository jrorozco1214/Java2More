package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class binaryTreeLevelOrderTraversalII107 {

    public static class TreeNode{

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

        System.out.println(levelOrderBottom(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(levelOrderBottom(new TreeNode(1)));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){

            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            ArrayList<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode n = q.remove();

                if(n.left != null){

                    q.add(n.left);
                }

                if(n.right != null){

                    q.add(n.right);
                }

                temp.add(n.val);
            }

            s.push(temp);
        }

        while(!s.isEmpty()) {

            List<Integer> top = s.pop();

            result.add(top);
        }
        
        return result;
    }
}
