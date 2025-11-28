package TreesMaps;

public class BinaryTrees {
    static class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

static class BST {
    Node root;

    BST() {
        root = null;
    }

    // INSERT operation
    void insert(int key) {
        root = insertRec(root, key); //remember that this is linked list techincally/ can be thought of as a doubly linked list
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key); //in insert we're creating new nodes for the numbers
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // SEARCH operation
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) { //when starting for search we will start with the root and 
        if (root == null)                   //if it does not find the value it will either go left or right depending on the value
            return false;                   //then it will go into recursion

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // DELETE operation
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null){
            return root;
        }

        if (key < root.key){
            root.left = deleteRec(root.left, key);
        } else if (key > root.key){
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            root = root.left;
            minv = root.key;
        }
        return minv;
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preOrder(){
        preOrderRec(root);
        System.out.println();
    }

    void preOrderRec(Node root){
        if(root != null){
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder Traversal: ");
        tree.inorder();

         tree.preOrder();

        // Search
        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 90: " + tree.search(90));

        // Delete nodes
        // tree.delete(20);
        // tree.delete(30);
        tree.delete(50);

        System.out.print("Inorder After Deletion: ");
        tree.inorder();

        tree.preOrder();
    }
}
}
