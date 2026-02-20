public class Review {

    public static class BinaryTree {

        public int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value){
            this.value = value;
            left = null;
            right = null;
        }

        public String toString(){

            return "Tree( " + this.value + ", " + this.left + ", " + this.right + " )";
        }
        
    }

    public static void main(String[] args) {

        int ar[] = {2, 5, 9, 8, 10, 3};

        BinaryTree tree = algo(ar);

        System.out.println(tree.toString());



    }

    public static BinaryTree algo(int []ar){ //
        BinaryTree b = new BinaryTree(ar[0]);

        for(int i = 1; i < ar.length; i++){ 

            insert(ar[i], b);
        }

        return b;
    }

    public static void insert(int value, BinaryTree s){

        if(value < s.value){

            if(s.left == null){
                s.left = new BinaryTree(value); //this still creates a new object
            } else {
                insert(value, s.left);
            }

        } else {

            if(s.right == null){

                s.right = new BinaryTree(value);

            } else {
                insert(value, s.right);
            }
        } 
    }
}
