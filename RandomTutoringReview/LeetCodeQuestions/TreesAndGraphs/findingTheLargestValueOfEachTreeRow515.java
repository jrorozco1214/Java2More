package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findingTheLargestValueOfEachTreeRow515 {

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

        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        ArrayList<Integer> result = new ArrayList<>(largestValues(t2));

        for(Integer x: result){
            System.out.println(x);
        }
    }


    public static List<Integer> largestValues(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        result.add(root.val);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                TreeNode node = queue.remove();

                if(node.left != null){

                    queue.add(node.left);
                    temp.add(node.left.val);
                }

                if(node.right != null){

                    queue.add(node.right);
                    temp.add(node.right.val);
                }
            }

            if(queue.isEmpty()){
                break;
            }

            result.add(Collections.max(temp));
            temp.clear();
        }
        return result;
    }
}
