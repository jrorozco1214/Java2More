package LeetCodeQuestions.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;

public class minimumAbsDiffInBST530 {

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

        TreeNode t1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));

        System.out.println(getMinimumDifference(t1));
    }


    public static int getMinimumDifference(TreeNode root) {


        ArrayList<Integer> nodeVals = new ArrayList<>();
        hGetMinDifference(root, nodeVals);

        Collections.sort(nodeVals);

        int minVal = Integer.MAX_VALUE;


        for(int i = 0; i < nodeVals.size(); i++){

            for(int j = i + 1; j < nodeVals.size(); j++){

                int sub = Math.abs(nodeVals.get(i) - nodeVals.get(j));

                minVal = Math.min(minVal, sub);
            }
        }
        return minVal;

    }

    public static ArrayList<Integer> hGetMinDifference(TreeNode root, ArrayList<Integer> nodeVal){


        if(root == null){

            return nodeVal;
        }

        if(root.left == null && root.right == null){

            nodeVal.add(root.val);

            return nodeVal;
        }

        hGetMinDifference(root.left, nodeVal);
        hGetMinDifference(root.right, nodeVal);

        nodeVal.add(root.val);

        return nodeVal;
    }
    
}
