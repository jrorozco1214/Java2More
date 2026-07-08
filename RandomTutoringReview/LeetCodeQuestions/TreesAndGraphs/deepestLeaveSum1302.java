package LeetCodeQuestions.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class deepestLeaveSum1302 {

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

        TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        TreeNode t2 = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))), new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
        System.out.println(deepestLeavesSum(t2));
    }

    public static int deepestLeavesSum(TreeNode root) {

        if(root == null){
            return 0;
        }

        int maxDepth = 0;
        int sum = 0;
        int counter = 0;
        

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++){

                TreeNode node = queue.remove();


                if(node.left != null){

                    queue.add(node.left);
                }

                if(node.right != null){

                    queue.add(node.right);
                }
            }

            maxDepth++;
        }

        queue.add(root);

        while(!queue.isEmpty()){

            if(counter == maxDepth-1){

                for(TreeNode x: queue){

                    sum += x.val;
                }

                break;
            }

            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++){


                TreeNode node = queue.remove();


                if(node.left != null){

                    queue.add(node.left);
                }

                if(node.right != null){

                    queue.add(node.right);
                }
            }
            counter++;
        }

        return sum;
    }
}
