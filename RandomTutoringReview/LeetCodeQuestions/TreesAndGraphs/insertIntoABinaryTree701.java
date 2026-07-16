package LeetCodeQuestions.TreesAndGraphs;

public class insertIntoABinaryTree701 {

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

        // public static TreeNode createTree(int... array){

        //     TreeNode root = new TreeNode(array[0]);
        //     TreeNode r = root.right;
        //     TreeNode l = root.left;

        //     for(int i = 1; i < array.length; i++){

        //         if(array[i] < root.val){

        //             if(l == null){

        //                 l = new TreeNode(array[i]);
        //             } else {

        //                 while(l.left )
        //             }
        //         } else if(array[i] > root.val){


        //         }
        //     }
        // }
    }

    public static void main(String[] args) {

        //TreeNode t1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        TreeNode t2 = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(5), new TreeNode(7))), new TreeNode(10, null, new TreeNode(18, new TreeNode(12), null)));

        insertIntoBST(t2, 5);

        

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){

            return new TreeNode(val);
        }

        if(val < root.val){

            root.left = insertIntoBST(root.left, val);
        } else {

            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
