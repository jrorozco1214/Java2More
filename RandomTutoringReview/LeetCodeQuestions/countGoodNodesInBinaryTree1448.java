package LeetCodeQuestions;

public class countGoodNodesInBinaryTree1448 {

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

        // TreeNode t1 = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        // TreeNode t2 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
        TreeNode t3 = new TreeNode(2, null, new TreeNode(4, new TreeNode(10), new TreeNode(8, new TreeNode(4), null)));


        System.out.println(goodNodes(t3));
    }

    public static int goodNodes(TreeNode root) {

        int counter = 0;
        int changingRootVal = root.val;

        return helperMethod(root, changingRootVal, counter);
    }

    public static int helperMethod(TreeNode root, int changingRootVal, int counter){

        if(root == null){
            return counter;
        }

        if(root.left == null && root.right == null){
            
            if(changingRootVal >= root.val){
                
                return ++counter;
            }
            
            return counter;
        }

        if(changingRootVal >= root.val){

            changingRootVal = root.val;
            counter++;
        }

        int left = helperMethod(root.left, changingRootVal, counter);
        counter = 0;
        int right = helperMethod(root.right, changingRootVal, counter);
        counter = 0;

        return left + right;
    }
}
