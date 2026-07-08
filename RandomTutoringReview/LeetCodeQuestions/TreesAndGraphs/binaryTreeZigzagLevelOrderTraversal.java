package LeetCodeQuestions.TreesAndGraphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class binaryTreeZigzagLevelOrderTraversal {

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

        TreeNode t1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode t3 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

        System.out.println(zigzagLevelOrder(t3));
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();

        if(root == null){

            return result; 
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        //boolean switchDirection = true;

        int switchDirection = 1;

        temp.add(root.val);

        result.add(temp);

            while(!queue.isEmpty()){

                temp = new ArrayList<>();

                int queueSize = queue.size();


                for(int i = 0; i < queueSize; i++){

                    TreeNode node = queue.remove();


                    if(node.left != null){

                        queue.add(node.left);
                    }

                    if(node.right != null){

                        queue.add(node.right);
                    }
                }

                if(switchDirection % 2 == 1){

                    Stack<TreeNode> stack = new Stack<>();

                    Queue<TreeNode> tempQ = queue;

                    while(!tempQ.isEmpty()) {

                        stack.push(tempQ.remove());
                    }

                    for(TreeNode x: stack){

                        temp.add(x.val);
                    }
                }
                
                if(queue.isEmpty()){

                    break;
                }
            
                for(TreeNode x: queue){

                    temp.add(x.val);
                }

                

                switchDirection++;

            result.add(temp);
        }

        return result;
    } 
}
