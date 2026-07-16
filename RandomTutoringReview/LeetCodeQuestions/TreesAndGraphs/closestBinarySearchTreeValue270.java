package LeetCodeQuestions.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class closestBinarySearchTreeValue270 {

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

    public static int value = -1;

    public static void main(String[] args) {

        TreeNode n = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));

        int y = 2;
        System.out.println(closestValue(new TreeNode(1), 4.428571));
    }

    public static int closestValue(TreeNode root, double target) {

       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);

       double minValue = Double.MAX_VALUE;
       int ans = 0;

       double calc = Math.abs(target - queue.peek().val);
       double temp = minValue;

        if(calc < temp){

            ans = root.val;
            minValue = calc;
        }

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                TreeNode n = queue.remove();

                if(n.left != null){

                    queue.add(n.left);
                }

                if(n.right != null){

                    queue.add(n.right);
                }
            }

            for(TreeNode x: queue){

                calc = Math.abs(target - x.val);

                temp = minValue;

                if(calc < temp){

                    ans = x.val;
                    minValue = calc;
                } else if( calc == temp){

                    ans = Math.min(ans,x.val);
                }
            }
        }

        return ans;
    }

    public static int closestValue1(TreeNode root, double target) {
        double diff = Integer.MAX_VALUE;
        int value = -1;
        dfs(root, target, diff);
        return value;
    }
    private static void dfs(TreeNode node, double target, double diff) {
        if (node == null){

            return;
        }

        if (Math.abs(target - node.val) <= diff) {

            if (Math.abs(target - node.val) == diff) {

                value = Math.min(value, node.val);
            } else {

                value = node.val;    
            }

            diff = Math.abs(target - node.val);
        }

        dfs(node.left, target, diff);
        
        dfs(node.right, target, diff);
    }
}
