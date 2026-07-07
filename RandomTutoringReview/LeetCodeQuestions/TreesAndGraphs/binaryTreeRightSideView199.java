package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeRightSideView199 {

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

        TreeNode t1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null), new TreeNode(3, null, null));
        // TreeNode t2 = new TreeNode(null);

        ArrayList<Integer> finalResult = new ArrayList<>(rightSideView(t2));

        for(Integer x: finalResult){
            System.out.println(x);
        }
        

    }

    public static List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> finalResult = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        if(root == null){
            return finalResult;
        }

        finalResult.add(root.val);

        while(!queue.isEmpty()){

            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++){

                TreeNode node = queue.remove();

                if(node.right != null){

                    queue.add(node.right);
                }

                if(node.left != null){

                    queue.add(node.left);
                }
            }

            if(queue.isEmpty()){
                break;
            }

            finalResult.add(queue.peek().val);
        }
        return finalResult;
    }
}
