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
    }

    public static void main(String[] args) {

        //TreeNode t1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        TreeNode t2 = new TreeNode(8, null, new TreeNode(55, new TreeNode(39, new TreeNode(11, t1, new TreeNode(23)), null), null));

        insertIntoBST(t2, 17);

        

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if(val < root.val){

            root = root.left;
        } else {
          
            root = root.right;
        }

        TreeNode result = hInsertIntoBST(root, val);

        result = root;

        return result;
    }

    public static TreeNode hInsertIntoBST(TreeNode root, int val){

        if(root.left == null && root.right == null){

            if(val < root.val){

                root.left = new TreeNode(val);
                return root;
            } else {

                root.right = new TreeNode(val);
                return root;
            }
        } else if(root.left == null && root.right != null){

            root.left = new TreeNode(val);
            return root;
        } else if(root.left != null && root.right == null){

            root.right = new TreeNode(val);
            return root;
        }
        
        
        if(val < root.val){

            root = root.left;
        } else {

            root = root.right;
        }

        hInsertIntoBST(root, val);

        return root;

    }
}
