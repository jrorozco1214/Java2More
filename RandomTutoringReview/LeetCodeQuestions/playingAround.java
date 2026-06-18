package LeetCodeQuestions;


public class playingAround {

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

        TreeNode root = new TreeNode(0, new TreeNode(5), new TreeNode(3));

        iterate(root);

    }

    public static void iterate(TreeNode root){

        TreeNode traverse = root;
        
        if(traverse == null){
            return;
        }
        
        System.out.println(root.val);
        iterate(root.left);
        iterate(root.right);
        return;

    }
    
}
